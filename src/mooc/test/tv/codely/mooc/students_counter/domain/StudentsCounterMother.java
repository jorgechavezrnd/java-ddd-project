package tv.codely.mooc.students_counter.domain;

import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.shared.domain.ListMother;

import java.util.ArrayList;
import java.util.List;

public final class StudentsCounterMother {
    public static StudentsCounter create(
        StudentsCounterId id,
        StudentsCounterTotal total,
        List<StudentId> existingStudents
    ) {
        return new StudentsCounter(id, total, existingStudents);
    }

    public static StudentsCounter withOne(StudentId studentId) {
        return create(StudentsCounterIdMother.random(), StudentsCounterTotalMother.one(), ListMother.one(studentId));
    }

    public static StudentsCounter random() {
        List<StudentId> existingStudents = ListMother.random(StudentIdMother::random);

        return create(
            StudentsCounterIdMother.random(),
            StudentsCounterTotalMother.create(existingStudents.size()),
            existingStudents
        );
    }

    public static StudentsCounter incrementing(StudentsCounter existingCounter, StudentId studentId) {
        List<StudentId> existingStudents = new ArrayList<>(existingCounter.existingStudents());
        existingStudents.add(studentId);

        return create(
            existingCounter.id(),
            StudentsCounterTotalMother.create(existingCounter.total().value() + 1),
            existingStudents
        );
    }
}
