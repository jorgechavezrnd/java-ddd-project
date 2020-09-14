package tv.codely.shared.infrastructure.bus.event.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.Utils;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;
import tv.codely.shared.infrastructure.bus.event.in_memory.InMemoryEventBus;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public final class MySqlEventBus implements EventBus {
    private final SessionFactory   sessionFactory;
    private final InMemoryEventBus failoverPublisher;

    public MySqlEventBus(SessionFactory sessionFactory, InMemoryEventBus failoverPublisher) {
        this.sessionFactory    = sessionFactory;
        this.failoverPublisher = failoverPublisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            String                        id          = domainEvent.eventId();
            String                        aggregateId = domainEvent.aggregateId();
            String                        name        = domainEvent.eventName();
            HashMap<String, Serializable> body        = domainEvent.toPrimitives();
            String                        occurredOn  = domainEvent.occurredOn();

            NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
                "INSERT INTO domain_events (id, aggregate_id, name, body, occurred_on) " +
                    "VALUES (:id, :aggregateId, :name, :body, :occurredOn);"
            );

            query.setParameter("id", id)
                .setParameter("aggregateId", aggregateId)
                .setParameter("name", name)
                .setParameter("body", Utils.jsonEncode(body))
                .setParameter("occurredOn", occurredOn);

            query.executeUpdate();
        } catch (Exception e) {
            this.failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }
}
