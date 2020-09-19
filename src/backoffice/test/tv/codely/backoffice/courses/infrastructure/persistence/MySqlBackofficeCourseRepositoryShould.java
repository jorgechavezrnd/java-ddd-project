package tv.codely.backoffice.courses.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tv.codely.backoffice.BackofficeContextInfrastructureTestCase;
import tv.codely.backoffice.courses.domain.BackofficeCourse;
import tv.codely.backoffice.courses.domain.BackofficeCourseMother;
import tv.codely.backoffice.courses.domain.BackofficeCourseRepository;

import javax.transaction.Transactional;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@Transactional
class MySqlBackofficeCourseRepositoryShould extends BackofficeContextInfrastructureTestCase {
    @Autowired
    @Qualifier("mySqlBackofficeCourseRepository")
    private BackofficeCourseRepository repository;

    @Test
    void save_a_course() {
        repository.save(BackofficeCourseMother.random());
    }

    @Test
    void search_all_existing_courses() {
        BackofficeCourse course        = BackofficeCourseMother.random();
        BackofficeCourse anotherCourse = BackofficeCourseMother.random();

        repository.save(course);
        repository.save(anotherCourse);

        assertThat(Arrays.asList(course, anotherCourse), containsInAnyOrder(repository.searchAll().toArray()));
    }
}
