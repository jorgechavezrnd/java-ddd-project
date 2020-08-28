package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.WordMother;

public final class StudentEmailMother {
    public static StudentEmail create(String value) {
        return new StudentEmail(value);
    }

    public static StudentEmail random() {
        return create(
            String.format(
                "%s@%s.%s",
                WordMother.random(),
                WordMother.random(),
                WordMother.random()
            )
        );
    }
}
