package tv.codely.mooc.videos_counter.application.find;

import tv.codely.mooc.videos_counter.application.VideosCounterResponse;
import tv.codely.mooc.videos_counter.domain.VideosCounter;
import tv.codely.mooc.videos_counter.domain.VideosCounterId;
import tv.codely.mooc.videos_counter.domain.VideosCounterNotInitialized;
import tv.codely.mooc.videos_counter.domain.VideosCounterRepository;
import tv.codely.shared.domain.Service;

@Service
public final class VideosCounterFinder {
    private VideosCounterRepository repository;

    public VideosCounterFinder(VideosCounterRepository repository) {
        this.repository = repository;
    }

    public VideosCounterResponse find(String videosCounterId) {
        VideosCounterId id = new VideosCounterId(videosCounterId);
        VideosCounter videosCounter = repository.search(id).orElseGet(() -> {
            throw new VideosCounterNotInitialized();
        });

        return new VideosCounterResponse(videosCounter.total().value());
    }
}
