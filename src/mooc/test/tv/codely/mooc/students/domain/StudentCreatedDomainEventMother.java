package tv.codely.mooc.students.domain;

public final class StudentCreatedDomainEventMother {
    public static StudentCreatedDomainEvent create(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        return new StudentCreatedDomainEvent(id.value(), name.value(), surname.value(), email.value());
    }

    public static StudentCreatedDomainEvent fromStudent(Student student) {
        return create(student.id(), student.name(), student.surname(), student.email());
    }

    public static StudentCreatedDomainEvent random() {
        return create(StudentIdMother.random(), StudentNameMother.random(), StudentSurnameMother.random(), StudentEmailMother.random());
    }
}
