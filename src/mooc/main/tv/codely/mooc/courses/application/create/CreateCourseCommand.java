package tv.codely.mooc.courses.application.create;

import tv.codely.shared.domain.bus.command.Command;

import java.util.Objects;

public final class CreateCourseCommand implements Command {
    private final String id;
    private final String name;
    private final String duration;

    public CreateCourseCommand(String id, String name, String duration) {
        this.id       = id;
        this.name     = name;
        this.duration = duration;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateCourseCommand)) return false;
        CreateCourseCommand that = (CreateCourseCommand) o;
        return id.equals(that.id) &&
            name.equals(that.name) &&
            duration.equals(that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
