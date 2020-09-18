package tv.codely.mooc.students_counter.application.find;

import tv.codely.mooc.students_counter.domain.StudentsCounter;
import tv.codely.mooc.students_counter.domain.StudentsCounterNotInitialized;
import tv.codely.mooc.students_counter.domain.StudentsCounterRepository;
import tv.codely.shared.domain.Service;

@Service
public final class StudentsCounterFinder {
    private StudentsCounterRepository repository;

    public StudentsCounterFinder(StudentsCounterRepository repository) {
        this.repository = repository;
    }

    public StudentsCounterResponse find() {
        StudentsCounter studentsCounter = repository.search().orElseGet(() -> {
            throw new StudentsCounterNotInitialized();
        });

        return new StudentsCounterResponse(studentsCounter.total().value());
    }
}
