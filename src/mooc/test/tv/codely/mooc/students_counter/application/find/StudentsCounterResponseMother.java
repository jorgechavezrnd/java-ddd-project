package tv.codely.mooc.students_counter.application.find;

import tv.codely.shared.domain.IntegerMother;

final class StudentsCounterResponseMother {
    public static StudentsCounterResponse create(Integer value) {
        return new StudentsCounterResponse(value);
    }

    public static StudentsCounterResponse random() {
        return create(IntegerMother.random());
    }
}
