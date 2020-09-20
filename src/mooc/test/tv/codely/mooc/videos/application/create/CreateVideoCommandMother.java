package tv.codely.mooc.videos.application.create;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.videos.domain.*;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.VideoUrlMother;

public final class CreateVideoCommandMother {
    public static CreateVideoCommand create(VideoId id, VideoType type, VideoTitle title, VideoUrl url, CourseId courseId) {
        return new CreateVideoCommand(
            id.value(),
            type.value(),
            title.value(),
            url.value(),
            courseId.value()
        );
    }

    public static CreateVideoCommand random() {
        return create(
            VideoIdMother.random(),
            VideoTypeMother.random(),
            VideoTitleMother.random(),
            VideoUrlMother.random(),
            CourseIdMother.random()
        );
    }
}
