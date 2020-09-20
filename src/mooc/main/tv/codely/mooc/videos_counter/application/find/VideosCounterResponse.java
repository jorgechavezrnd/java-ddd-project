package tv.codely.mooc.videos_counter.application.find;

import tv.codely.shared.domain.bus.query.Response;

import java.util.Objects;

public final class VideosCounterResponse implements Response {
    private Integer total;

    public VideosCounterResponse(Integer total) {
        this.total = total;
    }

    public Integer total() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideosCounterResponse that = (VideosCounterResponse) o;
        return total.equals(that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
