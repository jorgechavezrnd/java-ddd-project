package tv.codely.mooc.videos_counter.application.increment;

import org.springframework.context.event.EventListener;
import tv.codely.shared.domain.video.VideoCreatedDomainEvent;
import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos_counter.domain.VideosCounterId;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({VideoCreatedDomainEvent.class})
public final class IncrementVideosCounterOnVideoCreated {
    private final VideosCounterIncrementer incrementer;

    public IncrementVideosCounterOnVideoCreated(VideosCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(VideoCreatedDomainEvent event) {
        VideoId         videoId         = new VideoId(event.aggregateId());
        VideosCounterId videosCounterId = new VideosCounterId(event.courseId());

        incrementer.increment(videosCounterId, videoId);
    }
}
