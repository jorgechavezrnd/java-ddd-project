package tv.codely.mooc.students.application;

import tv.codely.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;

public final class StudentsResponseMother {
    public static StudentsResponse create(List<StudentResponse> students) {
        return new StudentsResponse(students);
    }

    public static StudentsResponse random() {
        return create(ListMother.random(StudentResponseMother::random));
    }

    public static StudentsResponse empty() {
        return create(Collections.emptyList());
    }
}
