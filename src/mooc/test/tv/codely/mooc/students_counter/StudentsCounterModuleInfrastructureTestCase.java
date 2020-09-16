package tv.codely.mooc.students_counter;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.students_counter.domain.StudentsCounterRepository;

public abstract class StudentsCounterModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    @Autowired
    protected StudentsCounterRepository repository;
}
