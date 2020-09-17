package tv.codely.mooc.videos.domain;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.VideoUrlMother;

public final class VideoCreatedDomainEventMother {
    public static VideoCreatedDomainEvent create(VideoId id, VideoType type, VideoTitle title, VideoUrl url, CourseId courseId) {
        return new VideoCreatedDomainEvent(
            id.value(),
            type.value(),
            title.value(),
            url.value(),
            courseId.value()
        );
    }

    public static VideoCreatedDomainEvent fromVideo(Video video) {
        return create(
            video.id(),
            video.type(),
            video.title(),
            video.url(),
            video.courseId()
        );
    }

    public static VideoCreatedDomainEvent random() {
        return create(
            VideoIdMother.random(),
            VideoTypeMother.random(),
            VideoTitleMother.random(),
            VideoUrlMother.random(),
            CourseIdMother.random()
        );
    }
}
