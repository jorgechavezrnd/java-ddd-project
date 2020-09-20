package tv.codely.mooc.videos_counter.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseMother;
import tv.codely.mooc.courses_counter.domain.CoursesCounter;
import tv.codely.mooc.videos_counter.VideosCounterModuleInfrastructureTestCase;
import tv.codely.mooc.videos_counter.domain.VideosCounter;
import tv.codely.mooc.videos_counter.domain.VideosCounterId;
import tv.codely.mooc.videos_counter.domain.VideosCounterIdMother;
import tv.codely.mooc.videos_counter.domain.VideosCounterMother;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@Transactional
class MySqlVideosCounterRepositoryShould extends VideosCounterModuleInfrastructureTestCase {
    @Test
    void return_an_existing_videos_counter() {
        Course course = CourseMother.random();
        courseRepository.save(course);
        VideosCounterId id = VideosCounterIdMother.create(course.id().value());
        VideosCounter counter = VideosCounterMother.random(id);

        videosCounterRepository.save(counter);

        assertEquals(Optional.of(counter), videosCounterRepository.search(id));
    }
}
