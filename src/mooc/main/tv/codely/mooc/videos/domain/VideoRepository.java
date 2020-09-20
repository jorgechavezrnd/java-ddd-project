package tv.codely.mooc.videos.domain;

import java.util.Optional;

public interface VideoRepository {
    void save(Video video);

    Optional<Video> search(VideoId id);
}
