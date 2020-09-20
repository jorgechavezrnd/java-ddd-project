package tv.codely.mooc.videos_counter;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import tv.codely.mooc.videos_counter.domain.VideosCounter;
import tv.codely.mooc.videos_counter.domain.VideosCounterId;
import tv.codely.mooc.videos_counter.domain.VideosCounterRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class VideosCounterModuleUnitTestCase extends UnitTestCase {
    protected VideosCounterRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(VideosCounterRepository.class);
    }

    public void shouldSearch(VideosCounterId id, VideosCounter counter) {
        Mockito.when(repository.search(id)).thenReturn(Optional.ofNullable(counter));
    }

    public void shouldSearch(VideosCounterId id) {
        Mockito.when(repository.search(id)).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(VideosCounter counter) {
        verify(repository, atLeastOnce()).save(counter);
    }
}
