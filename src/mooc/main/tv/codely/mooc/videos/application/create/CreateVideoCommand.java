package tv.codely.mooc.videos.application.create;

import tv.codely.shared.domain.bus.command.Command;

import java.util.Objects;

public final class CreateVideoCommand implements Command {
    private final String id;
    private final String type;
    private final String title;
    private final String url;
    private final String courseId;

    public CreateVideoCommand(String id, String type, String title, String url, String courseId) {
        this.id       = id;
        this.type     = type;
        this.title    = title;
        this.url      = url;
        this.courseId = courseId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateVideoCommand that = (CreateVideoCommand) o;
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
