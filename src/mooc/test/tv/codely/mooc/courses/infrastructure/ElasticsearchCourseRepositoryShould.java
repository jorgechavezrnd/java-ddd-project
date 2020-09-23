package tv.codely.mooc.courses.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseMother;
import tv.codely.mooc.courses.infrastructure.persistence.ElasticsearchCourseRepository;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class ElasticsearchCourseRepositoryShould extends MoocContextInfrastructureTestCase {
    @Autowired
    private ElasticsearchCourseRepository repository;

    @BeforeEach
    protected void setUp() throws IOException {
        clearElasticsearch();
    }

    @Test
    void save_a_course() {
        repository.save(CourseMother.random());
    }

    @Test
    void search_an_existing_course() throws Exception {
        Course course        = CourseMother.random();
        Course anotherCourse = CourseMother.random();

        repository.save(course);
        repository.save(anotherCourse);

        eventually(() -> assertEquals(Optional.of(course), repository.search(course.id())));
    }
}
