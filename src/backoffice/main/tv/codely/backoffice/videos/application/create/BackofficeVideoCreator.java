package tv.codely.backoffice.videos.application.create;

import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.Service;

@Service
public final class BackofficeVideoCreator {
    private final BackofficeVideoRepository repository;

    public BackofficeVideoCreator(BackofficeVideoRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String type, String title, String url, String courseId) {
        this.repository.save(new BackofficeVideo(id, type, title, url, courseId));
    }
}
