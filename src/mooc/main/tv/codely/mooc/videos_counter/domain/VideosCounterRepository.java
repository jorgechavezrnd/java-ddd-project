package tv.codely.mooc.videos_counter.domain;

import java.util.List;
import java.util.Optional;

public interface VideosCounterRepository {
    void save(VideosCounter counter);

    Optional<List<VideosCounter>> searchAll();

    Optional<VideosCounter> search(VideosCounterId id);
}
