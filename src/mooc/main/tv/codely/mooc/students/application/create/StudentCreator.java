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

    public void create(CreateStudentRequest request) {
        StudentId      id      = new StudentId(request.id());
        StudentName    name    = new StudentName(request.name());
        StudentSurname surname = new StudentSurname(request.surname());
        StudentEmail   email   = new StudentEmail(request.email());

        Student student = Student.create(id, name, surname, email);

        repository.save(student);
        eventBus.publish(student.pullDomainEvents());
    }
}
