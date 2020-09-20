package tv.codely.mooc.videos_counter.application.find;

import tv.codely.mooc.videos_counter.application.VideosCounterResponse;
import tv.codely.shared.domain.IntegerMother;

final class VideosCounterResponseMother {
    public static VideosCounterResponse create(Integer value) {
        return new VideosCounterResponse(value);
    }

    public static VideosCounterResponse random() {
        return create(IntegerMother.random());
    }
}
