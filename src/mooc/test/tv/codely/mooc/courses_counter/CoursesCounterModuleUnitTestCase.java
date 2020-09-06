package tv.codely.mooc.courses_counter;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import tv.codely.mooc.courses_counter.domain.CoursesCounter;
import tv.codely.mooc.courses_counter.domain.CoursesCounterRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class CoursesCounterModuleUnitTestCase extends UnitTestCase {
    protected CoursesCounterRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(CoursesCounterRepository.class);
    }

    public void shouldSearch(CoursesCounter counter) {
        Mockito.when(repository.search()).thenReturn(Optional.of(counter));
    }

    public void shouldSearch() {
        Mockito.when(repository.search()).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(CoursesCounter counter) {
        verify(repository, atLeastOnce()).save(counter);
    }
}
