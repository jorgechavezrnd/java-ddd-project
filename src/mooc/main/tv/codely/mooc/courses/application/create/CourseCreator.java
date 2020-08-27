package tv.codely.mooc.courses.application.create;

import tv.codely.mooc.courses.domain.*;
import tv.codely.shared.domain.domain.Service;

@Service
public final class CourseCreator {
    private final CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCourseRequest request) {
        Course course = new Course(
            new CourseId(request.id()),
            new CourseName(request.name()),
            new CourseDuration(request.duration())
        );

        repository.save(course);
    }
}
