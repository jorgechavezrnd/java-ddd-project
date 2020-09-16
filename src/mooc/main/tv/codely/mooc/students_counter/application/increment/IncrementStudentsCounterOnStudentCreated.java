package tv.codely.mooc.students_counter.application.increment;

import org.springframework.context.event.EventListener;
import tv.codely.mooc.students.domain.StudentCreatedDomainEvent;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.shared.domain.Service;

@Service
public final class IncrementStudentsCounterOnStudentCreated {
    private final StudentsCounterIncrementer incrementer;

    public IncrementStudentsCounterOnStudentCreated(StudentsCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(StudentCreatedDomainEvent event) {
        StudentId studentId = new StudentId(event.aggregateId());

        incrementer.increment(studentId);
    }
}
