package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

@Service
public final class StudentCreator {
    private StudentRepository repository;

    public StudentCreator(StudentRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name, String email) {
        Student student = new Student(id, name, email);

        repository.save(student);
    }
}
