package tv.codely.mooc.students_counter.application.increment;

import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students_counter.domain.StudentsCounter;
import tv.codely.mooc.students_counter.domain.StudentsCounterRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.UuidGenerator;

@Service
public final class StudentsCounterIncrementer {
    private final StudentsCounterRepository repository;
    private final UuidGenerator             uuidGenerator;

    public StudentsCounterIncrementer(StudentsCounterRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void increment(StudentId id) {
        StudentsCounter counter = repository.search()
                                            .orElseGet(() -> StudentsCounter.initialize(uuidGenerator.generate()));

        if (!counter.hasIncremented(id)) {
            counter.increment(id);

            repository.save(counter);
        }
    }
}
