package tv.codely.backoffice.videos.domain;

import tv.codely.shared.domain.criteria.Criteria;

import java.util.List;

public interface BackofficeVideoRepository {
    void save(BackofficeVideo video);

    List<BackofficeVideo> searchAll();

    List<BackofficeVideo> matching(Criteria criteria);
}
