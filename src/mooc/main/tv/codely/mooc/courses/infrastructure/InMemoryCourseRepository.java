package tv.codely.mooc.courses.infrastructure;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.domain.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public final class InMemoryCourseRepository implements CourseRepository {
    private final HashMap<CourseId, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        this.courses.put(course.id(), course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id));
    }
}
