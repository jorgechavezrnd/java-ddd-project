package tv.codely.apps.mooc.backend.controller.videos_counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.videos_counter.application.find.FindVideosCounterQuery;
import tv.codely.mooc.videos_counter.application.VideosCounterResponse;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;

import java.util.HashMap;

@RestController
public final class VideosCounterGetController {
    QueryBus bus;

    public VideosCounterGetController(QueryBus bus) {
        this.bus = bus;
    }

    @GetMapping("/videos-counter/{courseId}")
    public HashMap<String, Integer> index(
        @PathVariable String courseId
    ) throws QueryHandlerExecutionError {
        VideosCounterResponse response = bus.ask(new FindVideosCounterQuery(courseId));

        return new HashMap<String, Integer>() {{
            put("total", response.total());
        }};
    }
}
