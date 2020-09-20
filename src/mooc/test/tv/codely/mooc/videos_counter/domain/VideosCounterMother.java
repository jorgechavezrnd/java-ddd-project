package tv.codely.mooc.videos_counter.domain;

import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos.domain.VideoIdMother;
import tv.codely.shared.domain.ListMother;

import java.util.ArrayList;
import java.util.List;

public final class VideosCounterMother {
    public static VideosCounter create(
        VideosCounterId id,
        VideosCounterTotal total,
        List<VideoId> existingVideos
    ) {
        return new VideosCounter(id, total, existingVideos);
    }

    public static VideosCounter withOne(VideosCounterId id, VideoId videoId) {
        return create(id, VideosCounterTotalMother.one(), ListMother.one(videoId));
    }

    public static VideosCounter random() {
        List<VideoId> existingVideos = ListMother.random(VideoIdMother::random);

        return create(
            VideosCounterIdMother.random(),
            VideosCounterTotalMother.create(existingVideos.size()),
            existingVideos
        );
    }

    public static VideosCounter random(VideosCounterId id) {
        List<VideoId> existingVideos = ListMother.random(VideoIdMother::random);

        return create(
            id,
            VideosCounterTotalMother.create(existingVideos.size()),
            existingVideos
        );
    }

    public static VideosCounter incrementing(VideosCounter existingCounter, VideoId videoId) {
        List<VideoId> existingVideos = new ArrayList<>(existingCounter.existingVideos());
        existingVideos.add(videoId);

        return create(
            existingCounter.id(),
            VideosCounterTotalMother.create(existingCounter.total().value() + 1),
            existingVideos
        );
    }
}
