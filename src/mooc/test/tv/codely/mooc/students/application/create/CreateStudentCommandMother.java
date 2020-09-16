package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.*;

public final class CreateStudentCommandMother {
    public static CreateStudentCommand create(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        return new CreateStudentCommand(id.value(), name.value(), surname.value(), email.value());
    }

    public static CreateStudentCommand random() {
        return create(
            StudentIdMother.random(),
            StudentNameMother.random(),
            StudentSurnameMother.random(),
            StudentEmailMother.random()
        );
    }
}
