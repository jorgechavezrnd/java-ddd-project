package tv.codely.backoffice.videos.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tv.codely.backoffice.BackofficeContextInfrastructureTestCase;
import tv.codely.backoffice.courses.domain.BackofficeCourse;
import tv.codely.backoffice.courses.domain.BackofficeCourseMother;
import tv.codely.backoffice.courses.domain.BackofficeCourseRepository;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoMother;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;

import javax.transaction.Transactional;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@Transactional
class MySqlBackofficeVideoRepositoryShould extends BackofficeContextInfrastructureTestCase {
    @Autowired
    @Qualifier("mySqlBackofficeVideoRepository")
    private BackofficeVideoRepository videoRepository;

    @Autowired
    @Qualifier("mySqlBackofficeCourseRepository")
    private BackofficeCourseRepository courseRepository;

    @Test
    void save_a_video() {
        BackofficeCourse course = BackofficeCourseMother.random();
        courseRepository.save(course);

        videoRepository.save(BackofficeVideoMother.randomWithCourseId(course.id()));
    }

    @Test
    void search_all_existing_videos() {
        BackofficeCourse course = BackofficeCourseMother.random();
        courseRepository.save(course);

        BackofficeVideo video        = BackofficeVideoMother.randomWithCourseId(course.id());
        BackofficeVideo anotherVideo = BackofficeVideoMother.randomWithCourseId(course.id());

        videoRepository.save(video);
        videoRepository.save(anotherVideo);

        assertThat(Arrays.asList(video, anotherVideo), containsInAnyOrder(videoRepository.searchAll().toArray()));
    }
}
