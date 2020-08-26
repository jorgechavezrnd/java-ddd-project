package tv.codely.mooc.students.infrastructure;

import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public final class InMemoryStudentRepository implements StudentRepository {
    private final HashMap<String, Student> students = new HashMap<>();

    @Override
    public void save(Student student) {
        this.students.put(student.id(), student);
    }

    @Override
    public Optional<Student> search(String id) {
        return Optional.ofNullable(students.get(id));
    }
}
