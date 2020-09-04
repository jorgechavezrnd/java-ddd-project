package tv.codely.shared.domain;

public final class VideoUrl extends StringValueObject {
    public VideoUrl(String value) {
        super(value);
    }

    private VideoUrl() {
        super(null);
    }
}