package tv.codely.backoffice.videos.domain;

import tv.codely.shared.domain.UuidMother;
import tv.codely.shared.domain.WordMother;

public final class BackofficeVideoMother {
    public static BackofficeVideo create(String id, String type, String title, String url, String courseId) {
        return new BackofficeVideo(id, type, title, url, courseId);
    }

    public static BackofficeVideo create(String type, String title, String url, String courseId) {
        return create(UuidMother.random(), type, title,url, courseId);
    }

    public static BackofficeVideo randomWithCourseId(String courseId) {
        return create(UuidMother.random(), WordMother.random(), WordMother.random(), WordMother.random(), courseId);
    }
}
