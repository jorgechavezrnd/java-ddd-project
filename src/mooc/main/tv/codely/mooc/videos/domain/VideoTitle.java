package tv.codely.mooc.videos.domain;

import tv.codely.shared.domain.StringValueObject;

public final class VideoTitle extends StringValueObject {
    public VideoTitle(String value) {
        super(value);
    }

    private VideoTitle() {
        super("");
    }
}
