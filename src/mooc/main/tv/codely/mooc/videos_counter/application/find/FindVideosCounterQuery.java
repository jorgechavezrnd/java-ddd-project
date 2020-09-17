package tv.codely.mooc.videos_counter.application.find;

import tv.codely.shared.domain.bus.query.Query;

import java.util.Objects;

public final class FindVideosCounterQuery implements Query {
    private final String id;

    public FindVideosCounterQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindVideosCounterQuery that = (FindVideosCounterQuery) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
