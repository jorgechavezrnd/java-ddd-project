package tv.codely.mooc.videos.infrastructure.persistence;

import tv.codely.mooc.videos.domain.Video;
import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos.domain.VideoRepository;

import java.util.HashMap;
import java.util.Optional;

public final class InMemoryVideoRepository implements VideoRepository {
    private final HashMap<VideoId, Video> videos = new HashMap<>();

    @Override
    public void save(Video video) {
        this.videos.put(video.id(), video);
    }

    @Override
    public Optional<Video> search(VideoId id) {
        return Optional.ofNullable(videos.get(id));
    }
}
