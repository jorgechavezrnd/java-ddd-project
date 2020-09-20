package tv.codely.backoffice.videos.application.search_by_criteria;

import tv.codely.backoffice.videos.application.BackofficeVideoResponse;
import tv.codely.backoffice.videos.application.BackofficeVideosResponse;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.domain.criteria.Filters;
import tv.codely.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class BackofficeVideosByCriteriaSearcher {
    private final BackofficeVideoRepository repository;

    public BackofficeVideosByCriteriaSearcher(BackofficeVideoRepository repository) {
        this.repository = repository;
    }

    public BackofficeVideosResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new BackofficeVideosResponse(
            repository.matching(criteria).stream().map(BackofficeVideoResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
