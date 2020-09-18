package tv.codely.mooc.students_counter;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import tv.codely.mooc.students_counter.domain.StudentsCounter;
import tv.codely.mooc.students_counter.domain.StudentsCounterRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class StudentsCounterModuleUnitTestCase extends UnitTestCase {
    protected StudentsCounterRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(StudentsCounterRepository.class);
    }

    public void shouldSearch(StudentsCounter counter) {
        Mockito.when(repository.search()).thenReturn(Optional.of(counter));
    }

    public void shouldSearch() {
        Mockito.when(repository.search()).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(StudentsCounter counter) {
        verify(repository, atLeastOnce()).save(counter);
    }
}
