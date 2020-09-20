package tv.codely.mooc.videos_counter.application.find;

import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Service
public final class FindVideosCounterQueryHandler implements QueryHandler<FindVideosCounterQuery, VideosCounterResponse> {
    private final VideosCounterFinder finder;

    public FindVideosCounterQueryHandler(VideosCounterFinder finder) {
        this.finder = finder;
    }

    @Override
    public VideosCounterResponse handle(FindVideosCounterQuery query) {
        return finder.find(query.id());
    }
}
