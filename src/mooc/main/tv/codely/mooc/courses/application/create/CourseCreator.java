package tv.codely.mooc.courses.application.create;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

@Service
public final class CourseCreator {
    private final CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCourseRequest request) {
        Course course = new Course(request.id(), request.name(), request.duration());

        repository.save(course);
    }
}
