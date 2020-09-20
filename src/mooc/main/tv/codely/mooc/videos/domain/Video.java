package tv.codely.mooc.videos.domain;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.video.VideoCreatedDomainEvent;

import java.util.Objects;

public final class Video extends AggregateRoot {
    private final VideoId    id;
    private final VideoType  type;
    private final VideoTitle title;
    private final VideoUrl   url;
    private final CourseId   courseId;

    public Video(VideoId id, VideoType type, VideoTitle title, VideoUrl url, CourseId courseId) {
        this.id       = id;
        this.type     = type;
        this.title    = title;
        this.url      = url;
        this.courseId = courseId;
    }

    private Video() {
        this.id       = null;
        this.type     = null;
        this.title    = null;
        this.url      = null;
        this.courseId = null;
    }

    public static Video create(VideoId id, VideoType type, VideoTitle title, VideoUrl url, CourseId courseId) {
        Video video = new Video(id, type, title, url, courseId);

        video.record(new VideoCreatedDomainEvent(id.value(), type.value(), title.value(), url.value(), courseId.value()));

        return video;
    }

    public VideoId id() {
        return id;
    }

    public VideoType type() {
        return type;
    }

    public VideoTitle title() {
        return title;
    }

    public VideoUrl url() {
        return url;
    }

    public CourseId courseId() {
        return courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return id.equals(video.id) &&
            type.equals(video.type) &&
            title.equals(video.title) &&
            url.equals(video.url) &&
            courseId.equals(video.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, url, courseId);
    }
}
