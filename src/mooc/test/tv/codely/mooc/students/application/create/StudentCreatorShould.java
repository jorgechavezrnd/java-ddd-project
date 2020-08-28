package tv.codely.mooc.students.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentsModuleUnitTestCase;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentMother;

final class StudentCreatorShould extends StudentsModuleUnitTestCase {
    private StudentCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        creator = new StudentCreator(repository);
    }

    @Test
    void create_a_valid_student() {
        CreateStudentRequest request = CreateStudentRequestMother.random();

        Student student = StudentMother.fromRequest(request);

        creator.create(request);

        shouldHaveSaved(student);
    }
}
