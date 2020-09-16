package tv.codely.mooc.students_counter.domain;

import java.util.Optional;

public interface StudentsCounterRepository {
    void save(StudentsCounter counter);

    Optional<StudentsCounter> search();
}
