package tv.codely.mooc.videos.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.videos.domain.Video;
import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos.domain.VideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlVideoRepository extends HibernateRepository<Video> implements VideoRepository {
    public MySqlVideoRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Video.class);
    }

    @Override
    public void save(Video video) {
        persist(video);
    }

    @Override
    public Optional<Video> search(VideoId id) {
        return byId(id);
    }
}
