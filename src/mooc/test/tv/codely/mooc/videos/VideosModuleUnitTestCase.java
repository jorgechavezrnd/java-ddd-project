package tv.codely.mooc.videos;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.mooc.videos.domain.Video;
import tv.codely.mooc.videos.domain.VideoRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class VideosModuleUnitTestCase extends UnitTestCase {
    protected VideoRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(VideoRepository.class);
    }

    protected void shouldHaveSaved(Video video) {
        verify(repository, atLeastOnce()).save(video);
    }
}
