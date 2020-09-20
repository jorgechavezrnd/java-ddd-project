package tv.codely.mooc.videos_counter.domain;

import tv.codely.shared.domain.IntValueObject;

public final class VideosCounterTotal extends IntValueObject {
    public VideosCounterTotal(Integer value) {
        super(value);
    }

    public VideosCounterTotal() {
        super(null);
    }

    public static VideosCounterTotal initialize() {
        return new VideosCounterTotal(0);
    }

    public VideosCounterTotal increment() {
        return new VideosCounterTotal(value() + 1);
    }
}
