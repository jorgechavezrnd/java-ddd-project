package tv.codely.mooc.videos_counter.application.find;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.videos_counter.VideosCounterModuleUnitTestCase;
import tv.codely.mooc.videos_counter.application.VideosCounterResponse;
import tv.codely.mooc.videos_counter.domain.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class FindVideosCounterQueryHandlerShould extends VideosCounterModuleUnitTestCase {
    FindVideosCounterQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new FindVideosCounterQueryHandler(new VideosCounterFinder(repository));
    }

    @Test
    void find_an_existing_videos_counter() {
        VideosCounter counter = VideosCounterMother.random();
        FindVideosCounterQuery query = new FindVideosCounterQuery(counter.id().value());
        VideosCounterResponse response = VideosCounterResponseMother.create(counter.total().value());

        shouldSearch(counter.id(), counter);

        assertEquals(response, handler.handle(query));
    }

    @Test
    void throw_an_exception_when_videos_counter_does_not_exists() {
        VideosCounterId id = VideosCounterIdMother.random();
        FindVideosCounterQuery query = new FindVideosCounterQuery(id.value());

        shouldSearch(id);

        assertThrows(VideosCounterNotInitialized.class, () -> handler.handle(query));
    }
}
