package tv.codely.mooc.students_counter.domain;

import tv.codely.shared.domain.IntegerMother;

public final class StudentsCounterTotalMother {
    public static StudentsCounterTotal create(Integer value) {
        return new StudentsCounterTotal(value);
    }

    public static StudentsCounterTotal random() {
        return create(IntegerMother.random());
    }

    public static StudentsCounterTotal one() {
        return create(1);
    }
}
