package tv.codely.mooc.courses.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseDuration;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseName;

import java.util.Optional;

final class InMemoryCourseRepositoryShould {
    @Test
    void save_a_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = new Course(
            new CourseId("1aab45ba-3c7a-4344-8936-78466eca77fa"),
            new CourseName("name"),
            new CourseDuration("duration")
        );

        repository.save(course);
    }

    @Test
    void return_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = new Course(
            new CourseId("1aab45ba-3c7a-4344-8936-78466eca77fa"),
            new CourseName("name"),
            new CourseDuration("duration")
        );

        repository.save(course);

        Assert.assertEquals(Optional.of(course), repository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Assert.assertFalse(repository.search(new CourseId("6a778254-0708-4011-9ede-5d9c78fd1d15")).isPresent());
    }
}
