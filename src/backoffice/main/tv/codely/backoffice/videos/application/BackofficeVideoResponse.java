package tv.codely.backoffice.videos.application;

import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.shared.domain.bus.query.Response;

public final class BackofficeVideoResponse implements Response {
    private final String id;
    private final String type;
    private final String title;
    private final String url;
    private final String courseId;

    public BackofficeVideoResponse(String id, String type, String title, String url, String courseId) {
        this.id       = id;
        this.type     = type;
        this.title    = title;
        this.url      = url;
        this.courseId = courseId;
    }

    public static BackofficeVideoResponse fromAggregate(BackofficeVideo video) {
        return new BackofficeVideoResponse(video.id(), video.type(), video.title(), video.url(), video.courseId());
    }

    public String id() {
        return id;
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
}
