package tv.codely.mooc.courses.domain;

import tv.codely.mooc.courses.application.create.CreateCourseCommand;

public final class CourseMother {
    public static Course create(CourseId id, CourseName name, CourseDuration duration) {
        return new Course(id, name, duration);
    }

    public static Course fromCommand(CreateCourseCommand command) {
        return create(
            CourseIdMother.create(command.id()),
            CourseNameMother.create(command.name()),
            CourseDurationMother.create(command.duration())
        );
    }

    public static Course random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }
}
