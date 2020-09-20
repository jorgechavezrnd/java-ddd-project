package tv.codely.mooc.videos_counter.domain;

import tv.codely.shared.domain.IntegerMother;

public final class VideosCounterTotalMother {
    public static VideosCounterTotal create(Integer value) {
        return new VideosCounterTotal(value);
    }

    public static VideosCounterTotal random() {
        return create(IntegerMother.random());
    }

    public static VideosCounterTotal one() {
        return create(1);
    }
}
