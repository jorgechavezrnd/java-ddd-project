package tv.codely.mooc.videos_counter.application.increment;

import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos_counter.domain.VideosCounter;
import tv.codely.mooc.videos_counter.domain.VideosCounterId;
import tv.codely.mooc.videos_counter.domain.VideosCounterRepository;
import tv.codely.shared.domain.Service;

@Service
public final class VideosCounterIncrementer {
    private VideosCounterRepository repository;

    public VideosCounterIncrementer(VideosCounterRepository repository) {
        this.repository = repository;
    }

    public void increment(VideosCounterId id, VideoId videoId) {
        VideosCounter counter = repository.search(id)
                                          .orElseGet(() -> VideosCounter.initialize(id.value()));

        if (!counter.hasIncremented(videoId)) {
            counter.increment(videoId);

            repository.save(counter);
        }
    }
}
