package tv.codely.mooc.videos_counter.domain;

import tv.codely.shared.domain.UuidMother;

public final class VideosCounterIdMother {
    public static VideosCounterId create(String value) {
        return new VideosCounterId(value);
    }

    public static VideosCounterId random() {
        return create(UuidMother.random());
    }
}
