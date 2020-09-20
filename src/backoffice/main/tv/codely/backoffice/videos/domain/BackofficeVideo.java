package tv.codely.backoffice.videos.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class BackofficeVideo {
    private final String id;
    private final String type;
    private final String title;
    private final String url;
    private final String courseId;

    public BackofficeVideo() {
        id       = null;
        type     = null;
        title    = null;
        url      = null;
        courseId = null;
    }

    public BackofficeVideo(String id, String type, String title, String url, String courseId) {
        this.id       = id;
        this.type     = type;
        this.title    = title;
        this.url      = url;
        this.courseId = courseId;
    }

    public static BackofficeVideo fromPrimitives(Map<String, Object> plainData) {
        return new BackofficeVideo(
            (String) plainData.get("id"),
            (String) plainData.get("type"),
            (String) plainData.get("title"),
            (String) plainData.get("url"),
            (String) plainData.get("courseId")
        );
    }

    public String id() {
        return id;
    }

    public String type() {
        return type;
    }

    public String title() {
        return title;
    }

    public String url() {
        return url;
    }

    public String courseId() {
        return courseId;
    }

    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("id", id);
            put("type", type);
            put("title", title);
            put("url", url);
            put("courseId", courseId);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackofficeVideo that = (BackofficeVideo) o;
        return id.equals(that.id) &&
            type.equals(that.type) &&
            title.equals(that.title) &&
            url.equals(that.url) &&
            courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, url, courseId);
    }
}
