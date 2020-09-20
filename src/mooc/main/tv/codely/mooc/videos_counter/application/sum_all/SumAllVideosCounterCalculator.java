package tv.codely.mooc.videos_counter.application.sum_all;

import tv.codely.mooc.videos_counter.application.VideosCounterResponse;
import tv.codely.mooc.videos_counter.domain.VideosCounter;
import tv.codely.mooc.videos_counter.domain.VideosCounterRepository;
import tv.codely.mooc.videos_counter.domain.VideosCounterTotal;
import tv.codely.shared.domain.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class SumAllVideosCounterCalculator {
    private final VideosCounterRepository repository;

    public SumAllVideosCounterCalculator(VideosCounterRepository repository) {
        this.repository = repository;
    }

    public VideosCounterResponse calculate() {
        List<VideosCounter> allVideosCounter = repository.searchAll().orElseGet(ArrayList::new);

        int total = allVideosCounter.stream()
                                    .map(VideosCounter::total)
                                    .mapToInt(VideosCounterTotal::value)
                                    .sum();

        return new VideosCounterResponse(total);
    }
}
