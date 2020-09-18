package tv.codely.mooc.students_counter.domain;

import tv.codely.shared.domain.IntValueObject;

public final class StudentsCounterTotal extends IntValueObject {
    public StudentsCounterTotal(Integer value) {
        super(value);
    }

    public StudentsCounterTotal() {
        super(null);
    }

    public static StudentsCounterTotal initialize() {
        return new StudentsCounterTotal(0);
    }

    public StudentsCounterTotal increment() {
        return new StudentsCounterTotal(value() + 1);
    }
}
