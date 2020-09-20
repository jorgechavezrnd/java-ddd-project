package tv.codely.mooc.videos_counter.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.videos_counter.domain.VideosCounter;
import tv.codely.mooc.videos_counter.domain.VideosCounterId;
import tv.codely.mooc.videos_counter.domain.VideosCounterRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlVideosCounterRepository extends HibernateRepository<VideosCounter> implements VideosCounterRepository {
    public MySqlVideosCounterRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, VideosCounter.class);
    }

    @Override
    public void save(VideosCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<List<VideosCounter>> searchAll() {
        return Optional.ofNullable(all());
    }

    @Override
    public Optional<VideosCounter> search(VideosCounterId id) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<VideosCounter> criteria = builder.createQuery(aggregateClass);
        Root<VideosCounter> root = criteria.from(aggregateClass);
        criteria.select(root).where(builder.equal(root.get("id"), id));

        List<VideosCounter> videosCounter = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return 0 == videosCounter.size() ? Optional.empty() : Optional.ofNullable(videosCounter.get(0));
    }
}
