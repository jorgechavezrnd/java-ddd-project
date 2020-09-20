package tv.codely.mooc.videos_counter.domain;

import java.util.Optional;

public interface VideosCounterRepository {
    void save(VideosCounter counter);

    Optional<VideosCounter> search(VideosCounterId id);
}
