package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class StudentCreator {
    private final StudentRepository repository;
    private final EventBus eventBus;

    public StudentCreator(StudentRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        Student student = Student.create(id, name, surname, email);

        repository.save(student);
        eventBus.publish(student.pullDomainEvents());
    }
}
