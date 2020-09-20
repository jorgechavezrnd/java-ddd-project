package tv.codely.mooc.videos.domain;

import tv.codely.shared.domain.WordMother;

public final class VideoTypeMother {
    public static VideoType create(String value) {
        return new VideoType(value);
    }

    public static VideoType random() {
        return create(WordMother.random());
    }
}
