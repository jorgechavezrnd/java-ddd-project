package tv.codely.mooc.courses.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.courses.domain.*;
import tv.codely.mooc.courses.infrastructure.persistence.ElasticsearchCourseRepository;
import tv.codely.shared.domain.criteria.Criteria;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

    @Test
    void search_courses_using_a_criteria() throws Exception {
        Course matchingCourse        = CourseMother.create(CourseNameMother.create("DDD en Java"), CourseDurationMother.create("3 days"));
        Course anotherMatchingCourse = CourseMother.create(CourseNameMother.create("DDD en TypeScript"), CourseDurationMother.create("2.5 days"));
        Course intellijCourse        = CourseMother.create(CourseNameMother.create("Exprimiendo Intellij"), CourseDurationMother.create("48 hours"));
        Course cobolCourse           = CourseMother.create(CourseNameMother.create("DDD en Cobol"), CourseDurationMother.create("5 years"));

        Criteria     criteria = CourseCriteriaMother.nameAndDurationContains("DDD", "days");
        List<Course> expected = Arrays.asList(matchingCourse, anotherMatchingCourse);

        repository.save(matchingCourse);
        repository.save(anotherMatchingCourse);
        repository.save(intellijCourse);
        repository.save(cobolCourse);

        eventually(() -> assertEquals(expected, repository.matching(criteria)));
    }
}
