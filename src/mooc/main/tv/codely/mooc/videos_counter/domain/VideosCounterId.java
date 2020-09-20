package tv.codely.mooc.videos_counter.domain;

import tv.codely.shared.domain.Identifier;

public final class VideosCounterId extends Identifier {
    public VideosCounterId(String value) {
        super(value);
    }

    private VideosCounterId() {
    }
}
