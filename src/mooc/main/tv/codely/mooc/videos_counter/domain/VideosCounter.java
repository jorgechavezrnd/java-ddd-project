package tv.codely.mooc.videos_counter.domain;

import tv.codely.mooc.videos.domain.VideoId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class VideosCounter {
    private VideosCounterId    id;
    private VideosCounterTotal total;
    private List<VideoId>      existingVideos;

    public VideosCounter(VideosCounterId id, VideosCounterTotal total, List<VideoId> existingVideos) {
        this.id             = id;
        this.total          = total;
        this.existingVideos = existingVideos;
    }

    private VideosCounter() {
        this.id             = null;
        this.total          = null;
        this.existingVideos = null;
    }

    public VideosCounterId id() {
        return id;
    }

    public VideosCounterTotal total() {
        return total;
    }

    public List<VideoId> existingVideos() {
        return existingVideos;
    }

    public static VideosCounter initialize(String id) {
        return new VideosCounter(new VideosCounterId(id), VideosCounterTotal.initialize(), new ArrayList<>());
    }

    public boolean hasIncremented(VideoId id) {
        return existingVideos.contains(id);
    }

    public void increment(VideoId id) {
        total = total.increment();
        existingVideos.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideosCounter that = (VideosCounter) o;
        return id.equals(that.id) &&
            total.equals(that.total) &&
            existingVideos.equals(that.existingVideos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingVideos);
    }
}
