package tv.codely.mooc.videos.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseMother;
import tv.codely.mooc.videos.VideosModuleInfrastructureTestCase;
import tv.codely.mooc.videos.domain.Video;
import tv.codely.mooc.videos.domain.VideoIdMother;
import tv.codely.mooc.videos.domain.VideoMother;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlVideoRepositoryShould extends VideosModuleInfrastructureTestCase {
    @Test
    void save_a_video() {
        Course course = CourseMother.random();
        mySqlCourseRepository.save(course);
        Video video = VideoMother.randomWithCourseId(course.id());

        mySqlVideoRepository.save(video);
    }

    @Test
    void return_an_existing_video() {
        Course course = CourseMother.random();
        mySqlCourseRepository.save(course);
        Video video = VideoMother.randomWithCourseId(course.id());

        mySqlVideoRepository.save(video);

        assertEquals(Optional.of(video), mySqlVideoRepository.search(video.id()));
    }

    @Test
    void not_return_a_non_existing_video() {
        assertFalse(mySqlVideoRepository.search(VideoIdMother.random()).isPresent());
    }
}
