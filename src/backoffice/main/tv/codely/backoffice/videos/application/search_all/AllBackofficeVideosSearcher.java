package tv.codely.backoffice.videos.application.search_all;

import tv.codely.backoffice.videos.application.BackofficeVideoResponse;
import tv.codely.backoffice.videos.application.BackofficeVideosResponse;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class AllBackofficeVideosSearcher {
    private final BackofficeVideoRepository repository;

    public AllBackofficeVideosSearcher(BackofficeVideoRepository repository) {
        this.repository = repository;
    }

    public BackofficeVideosResponse search() {
        return new BackofficeVideosResponse(
            repository.searchAll().stream().map(BackofficeVideoResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
