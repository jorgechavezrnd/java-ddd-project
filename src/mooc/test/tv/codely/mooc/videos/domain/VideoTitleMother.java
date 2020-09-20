package tv.codely.mooc.videos.domain;

import tv.codely.shared.domain.WordMother;

public final class VideoTitleMother {
    public static VideoTitle create(String value) {
        return new VideoTitle(value);
    }

    public static VideoTitle random() {
        return create(String.format(
            "%s %s %s",
            WordMother.random(),
            WordMother.random(),
            WordMother.random()
        ));
    }
}
