package tv.codely.mooc.courses.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;

import java.util.Optional;

final class InMemoryCourseRepositoryShould {
    @Test
    void save_a_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        repository.save(new Course("some-id", "some-name", "some-duration"));
    }

    @Test
    void return_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Course course = new Course("some-id", "some-name", "some-duration");

        repository.save(course);

        Assert.assertEquals(Optional.of(course), repository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Assert.assertFalse(repository.search("non-existing-id").isPresent());
    }
}
