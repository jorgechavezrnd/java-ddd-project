package tv.codely.mooc.students;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.students.infrastructure.InMemoryStudentRepository;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

public abstract class StudentsModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected InMemoryStudentRepository repository;
}
