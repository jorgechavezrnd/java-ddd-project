package tv.codely.mooc.students.infrastructure.persistence;

import org.hibernate.SessionFactory;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

import javax.transaction.Transactional;
import java.util.Optional;

//@Service
public class MySqlStudentRepository implements StudentRepository {
    private final SessionFactory sessionFactory;

    public MySqlStudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Student.class, id));
    }
}
