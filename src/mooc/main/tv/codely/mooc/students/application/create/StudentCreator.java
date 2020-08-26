package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

@Service
public final class StudentCreator {
    private final StudentRepository repository;

    public StudentCreator(StudentRepository repository) {
        this.repository = repository;
    }

    public void create(CreateStudentRequest request) {
        Student student = new Student(
            request.id(),
            request.name(),
            request.surname(),
            request.email()
        );

        repository.save(student);
    }
}
