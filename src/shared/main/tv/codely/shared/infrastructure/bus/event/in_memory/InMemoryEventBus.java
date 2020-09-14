package tv.codely.shared.infrastructure.bus.event.in_memory;

import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;

import java.util.ArrayList;
import java.util.List;

@Service
public final class InMemoryEventBus implements EventBus {
    private final List<DomainEvent> eventsInMemory = new ArrayList<>();

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        this.eventsInMemory.add(domainEvent);
    }
}
