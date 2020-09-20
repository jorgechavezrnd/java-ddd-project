package tv.codely.mooc.videos.domain;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.videos.application.create.CreateVideoCommand;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.VideoUrlMother;

public final class VideoMother {
    public static Video create(VideoId id, VideoType type, VideoTitle title, VideoUrl url, CourseId courseId) {
        return new Video(id, type, title, url, courseId);
    }

    public static Video fromCommand(CreateVideoCommand command) {
        return create(
            VideoIdMother.create(command.id()),
            VideoTypeMother.create(command.type()),
            VideoTitleMother.create(command.title()),
            VideoUrlMother.create(command.url()),
            CourseIdMother.create(command.courseId())
        );
    }

    public static Video random() {
        return create(
            VideoIdMother.random(),
            VideoTypeMother.random(),
            VideoTitleMother.random(),
            VideoUrlMother.random(),
            CourseIdMother.random()
        );
    }

    public static Video randomWithCourseId(CourseId courseId) {
        return create(
            VideoIdMother.random(),
            VideoTypeMother.random(),
            VideoTitleMother.random(),
            VideoUrlMother.random(),
            courseId
        );
    }
}
