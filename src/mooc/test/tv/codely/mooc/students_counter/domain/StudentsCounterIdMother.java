package tv.codely.mooc.students_counter.domain;

import tv.codely.shared.domain.UuidMother;

public final class StudentsCounterIdMother {
    public static StudentsCounterId create(String value) {
        return new StudentsCounterId(value);
    }

    public static StudentsCounterId random() {
        return create(UuidMother.random());
    }
}
