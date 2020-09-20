package tv.codely.mooc.videos.domain;

import tv.codely.shared.domain.StringValueObject;

public final class VideoType extends StringValueObject {
    public VideoType(String value) {
        super(value);
    }

    private VideoType() {
        super("");
    }
}
