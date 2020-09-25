package tv.codely.analytics.domain_events.domain;

public final class AnalyticsDomainEvent {
    private final AnalyticsDomainEventId          id;
    private final AnalyticsDomainEventAggregateId aggregateId;
    private final AnalyticsDomainEventName        name;
    private final AnalyticsDomainEventBody        body;

    public AnalyticsDomainEvent(
        AnalyticsDomainEventId id,
        AnalyticsDomainEventAggregateId aggregateId,
        AnalyticsDomainEventName name,
        AnalyticsDomainEventBody body
    ) {
        this.id          = id;
        this.aggregateId = aggregateId;
        this.name        = name;
        this.body        = body;
    }

    public AnalyticsDomainEventId id() {
        return id;
    }

    public AnalyticsDomainEventAggregateId aggregateId() {
        return aggregateId;
    }

    public AnalyticsDomainEventName name() {
        return name;
    }

    public AnalyticsDomainEventBody body() {
        return body;
    }
}
