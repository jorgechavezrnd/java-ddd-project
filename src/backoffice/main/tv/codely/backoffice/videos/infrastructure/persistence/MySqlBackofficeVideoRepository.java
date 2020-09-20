package tv.codely.backoffice.videos.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Transactional("backoffice-transaction_manager")
public class MySqlBackofficeVideoRepository extends HibernateRepository<BackofficeVideo> implements BackofficeVideoRepository {
    public MySqlBackofficeVideoRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, BackofficeVideo.class);
    }

    @Override
    public void save(BackofficeVideo video) {
        persist(video);
    }

    public List<BackofficeVideo> searchAll() {
        return all();
    }

    @Override
    public List<BackofficeVideo> searchByCourseId(String courseId) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<BackofficeVideo> criteria = builder.createQuery(aggregateClass);
        Root<BackofficeVideo> root = criteria.from(aggregateClass);
        criteria.select(root).where(builder.equal(root.get("courseId"), courseId));

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }
}
