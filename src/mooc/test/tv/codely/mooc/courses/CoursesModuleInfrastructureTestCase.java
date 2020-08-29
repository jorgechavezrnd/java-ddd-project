package tv.codely.mooc.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.mooc.backend.MoocBackendApplication;
import tv.codely.mooc.courses.infrastructure.persistence.InMemoryCourseRepository;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = MoocBackendApplication.class)
@SpringBootTest
public abstract class CoursesModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected InMemoryCourseRepository repository;
}
