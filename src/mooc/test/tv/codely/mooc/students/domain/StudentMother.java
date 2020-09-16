package tv.codely.mooc.students.domain;

import tv.codely.mooc.students.application.create.CreateStudentRequest;

public final class StudentMother {
    public static Student create(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        return new Student(id, name, surname, email);
    }

    public static Student fromRequest(CreateStudentRequest request) {
        return create(
            StudentIdMother.create(request.id()),
            StudentNameMother.create(request.name()),
            StudentSurnameMother.create(request.surname()),
            StudentEmailMother.create(request.email())
        );
    }

    public static Student random() {
        return create(
            StudentIdMother.random(),
            StudentNameMother.random(),
            StudentSurnameMother.random(),
            StudentEmailMother.random()
        );
    }
}
