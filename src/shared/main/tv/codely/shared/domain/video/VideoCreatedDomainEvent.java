package tv.codely.shared.domain.video;

import tv.codely.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class VideoCreatedDomainEvent extends DomainEvent<VideoCreatedDomainEvent> {
    private final String type;
    private final String title;
    private final String url;
    private final String courseId;

    public VideoCreatedDomainEvent() {
        super(null);

        this.type     = null;
        this.title    = null;
        this.url      = null;
        this.courseId = null;
    }

    public VideoCreatedDomainEvent(
        String aggregateId,
        String type,
        String title,
        String url,
        String courseId
    ) {
        super(aggregateId);

        this.type     = type;
        this.title    = title;
        this.url      = url;
        this.courseId = courseId;
    }

    public VideoCreatedDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String type,
        String title,
        String url,
        String courseId
    ) {
        super(aggregateId, eventId, occurredOn);

        this.type     = type;
        this.title    = title;
        this.url      = url;
        this.courseId = courseId;
    }

    @Override
    public String eventName() {
        return "video.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("type", type);
            put("title", title);
            put("url", url);
            put("courseId", courseId);
        }};
    }

    @Override
    public VideoCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new VideoCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("type"),
            (String) body.get("title"),
            (String) body.get("url"),
            (String) body.get("courseId")
        );
    }

    public String type() {
        return type;
    }

    public String title() {
        return title;
    }

    public String url() {
        return url;
    }

    public String courseId() {
        return courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoCreatedDomainEvent that = (VideoCreatedDomainEvent) o;
        return type.equals(that.type) &&
            title.equals(that.title) &&
            url.equals(that.url) &&
            courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, url, courseId);
    }
}
