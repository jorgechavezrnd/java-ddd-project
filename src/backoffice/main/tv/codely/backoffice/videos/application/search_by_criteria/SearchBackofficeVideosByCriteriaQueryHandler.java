package tv.codely.backoffice.videos.application.search_by_criteria;

import tv.codely.backoffice.videos.application.BackofficeVideosResponse;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.query.QueryHandler;
import tv.codely.shared.domain.criteria.Filters;
import tv.codely.shared.domain.criteria.Order;

@Service
public final class SearchBackofficeVideosByCriteriaQueryHandler implements QueryHandler<SearchBackofficeVideosByCriteriaQuery, BackofficeVideosResponse> {
    private final BackofficeVideosByCriteriaSearcher searcher;

    public SearchBackofficeVideosByCriteriaQueryHandler(BackofficeVideosByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BackofficeVideosResponse handle(SearchBackofficeVideosByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
