package tv.codely.mooc.students;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.mooc.students.infrastructure.persistence.InMemoryStudentRepository;

public abstract class StudentsModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    protected InMemoryStudentRepository inMemoryStudentRepository = new InMemoryStudentRepository();
    @Autowired
    protected StudentRepository         mySqlStudentRepository;
}
