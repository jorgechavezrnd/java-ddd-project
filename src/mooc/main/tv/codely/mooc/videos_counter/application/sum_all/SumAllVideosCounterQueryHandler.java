package tv.codely.mooc.videos_counter.application.sum_all;

import tv.codely.mooc.videos_counter.application.VideosCounterResponse;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Service
public final class SumAllVideosCounterQueryHandler implements QueryHandler<SumAllVideosCounterQuery, VideosCounterResponse> {
    private final SumAllVideosCounterCalculator calculator;

    public SumAllVideosCounterQueryHandler(SumAllVideosCounterCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public VideosCounterResponse handle(SumAllVideosCounterQuery query) {
        return calculator.calculate();
    }
}
