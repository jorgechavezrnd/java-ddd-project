package tv.codely.mooc.students_counter.infrastructure.persistence;

import org.hibernate.SessionFactory;
import tv.codely.mooc.students_counter.domain.StudentsCounter;
import tv.codely.mooc.students_counter.domain.StudentsCounterRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Service
public final class MySqlStudentsCounterRepository extends HibernateRepository<StudentsCounter> implements StudentsCounterRepository {
    public MySqlStudentsCounterRepository(SessionFactory sessionFactory) {
        super(sessionFactory, StudentsCounter.class);
    }

    @Override
    public void save(StudentsCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<StudentsCounter> search() {
        CriteriaBuilder                builder  = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<StudentsCounter> criteria = builder.createQuery(aggregateClass);
        criteria.from(aggregateClass);
        List<StudentsCounter> studentsCounter = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return 0 == studentsCounter.size() ? Optional.empty() : Optional.ofNullable(studentsCounter.get(0));
    }
}
