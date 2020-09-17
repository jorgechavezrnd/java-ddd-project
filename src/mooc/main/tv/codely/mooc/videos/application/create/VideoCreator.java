package tv.codely.mooc.videos.application.create;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.videos.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class VideoCreator {
    private final VideoRepository repository;
    private final EventBus        eventBus;

    public VideoCreator(VideoRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(VideoId id, VideoType type, VideoTitle title, VideoUrl url, CourseId courseId) {
        Video video = Video.create(id, type, title, url, courseId);

        repository.save(video);
        eventBus.publish(video.pullDomainEvents());
    }
}
