package tv.codely.mooc.videos_counter.application.increment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.videos.domain.VideoCreatedDomainEventMother;
import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos.domain.VideoIdMother;
import tv.codely.mooc.videos_counter.VideosCounterModuleUnitTestCase;
import tv.codely.mooc.videos_counter.domain.VideosCounter;
import tv.codely.mooc.videos_counter.domain.VideosCounterId;
import tv.codely.mooc.videos_counter.domain.VideosCounterIdMother;
import tv.codely.mooc.videos_counter.domain.VideosCounterMother;
import tv.codely.shared.domain.video.VideoCreatedDomainEvent;

final class IncrementVideosCounterOnVideoCreatedShould extends VideosCounterModuleUnitTestCase {
    IncrementVideosCounterOnVideoCreated subscriber;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subscriber = new IncrementVideosCounterOnVideoCreated(
            new VideosCounterIncrementer(repository)
        );
    }

    @Test
    void initialize_a_new_counter() {
        VideoCreatedDomainEvent event = VideoCreatedDomainEventMother.random();
        VideosCounterId         id    = VideosCounterIdMother.create(event.courseId());

        VideoId       videoId    = VideoIdMother.create(event.aggregateId());
        VideosCounter newCounter = VideosCounterMother.withOne(id, videoId);

        shouldSearch(id);

        subscriber.on(event);

        shouldHaveSaved(newCounter);
    }

    @Test
    void increment_an_existing_counter() {
        VideoCreatedDomainEvent event = VideoCreatedDomainEventMother.random();
        VideosCounterId         id    = VideosCounterIdMother.create(event.courseId());

        VideoId       videoId            = VideoIdMother.create(event.aggregateId());
        VideosCounter existingCounter    = VideosCounterMother.random(id);
        VideosCounter incrementedCounter = VideosCounterMother.incrementing(existingCounter, videoId);

        shouldSearch(id, existingCounter);

        subscriber.on(event);

        shouldHaveSaved(incrementedCounter);
    }

    @Test
    void not_increment_an_already_incremented_video() {
        VideoCreatedDomainEvent event = VideoCreatedDomainEventMother.random();
        VideosCounterId         id    = VideosCounterIdMother.create(event.courseId());

        VideoId       videoId         = VideoIdMother.create(event.aggregateId());
        VideosCounter existingCounter = VideosCounterMother.withOne(id, videoId);

        shouldSearch(id, existingCounter);

        subscriber.on(event);
    }
}
