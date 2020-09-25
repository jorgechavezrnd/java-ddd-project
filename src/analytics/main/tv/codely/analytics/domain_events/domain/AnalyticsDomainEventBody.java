package tv.codely.analytics.domain_events.domain;

import java.io.Serializable;
import java.util.HashMap;

public final class AnalyticsDomainEventBody {
    private final HashMap<String, Serializable> value;

    public AnalyticsDomainEventBody(HashMap<String, Serializable> value) {
        this.value = value;
    }

    public HashMap<String, Serializable> value() {
        return value;
    }
}
