package tv.codely.mooc.videos.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.videos.VideosModuleInfrastructureTestCase;
import tv.codely.mooc.videos.domain.Video;
import tv.codely.mooc.videos.domain.VideoIdMother;
import tv.codely.mooc.videos.domain.VideoMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryVideoRepositoryShould extends VideosModuleInfrastructureTestCase {
    @Test
    void save_a_video() {
        Video video = VideoMother.random();

        inMemoryVideoRepository.save(video);
    }

    @Test
    void return_an_existing_video() {
        Video video = VideoMother.random();

        inMemoryVideoRepository.save(video);

        assertEquals(Optional.of(video), inMemoryVideoRepository.search(video.id()));
    }

    @Test
    void not_return_a_non_existing_video() {
        assertFalse(inMemoryVideoRepository.search(VideoIdMother.random()).isPresent());
    }
}
