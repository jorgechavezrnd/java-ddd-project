package tv.codely.backoffice.videos.application.create;

import org.springframework.context.event.EventListener;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.video.VideoCreatedDomainEvent;

@Service
@DomainEventSubscriber({VideoCreatedDomainEvent.class})
public final class CreateBackofficeVideoOnVideoCreated {
    private final BackofficeVideoCreator creator;

    public CreateBackofficeVideoOnVideoCreated(BackofficeVideoCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(VideoCreatedDomainEvent event) {
        creator.create(event.aggregateId(), event.type(), event.title(), event.url(), event.courseId());
    }
}
