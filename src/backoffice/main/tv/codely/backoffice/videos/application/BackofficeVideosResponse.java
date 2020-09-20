package tv.codely.backoffice.videos.application;

import tv.codely.shared.domain.bus.query.Response;

import java.util.List;

public final class BackofficeVideosResponse implements Response {
    private final List<BackofficeVideoResponse> videos;

    public BackofficeVideosResponse(List<BackofficeVideoResponse> videos) {
        this.videos = videos;
    }

    public List<BackofficeVideoResponse> videos() {
        return videos;
    }
}
