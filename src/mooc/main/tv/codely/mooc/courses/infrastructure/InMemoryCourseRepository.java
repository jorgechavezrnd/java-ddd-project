package tv.codely.mooc.courses.infrastructure;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public final class InMemoryCourseRepository implements CourseRepository {
    private HashMap<String, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        this.courses.put(course.id(), course);
    }

    @Override
    public Optional<Course> search(String id) {
        return Optional.ofNullable(courses.get(id));
    }
}
