package tv.codely.apps.backoffice.frontend.controller.videos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.backoffice.videos.application.BackofficeVideosResponse;
import tv.codely.backoffice.videos.application.search_all.SearchAllBackofficeVideosQuery;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class ApiVideosGetController {
    private final QueryBus bus;

    public ApiVideosGetController(QueryBus bus) {
        this.bus = bus;
    }

    @GetMapping("/api/videos")
    public List<HashMap<String, String>> index() throws QueryHandlerExecutionError {
        BackofficeVideosResponse videos = bus.ask(new SearchAllBackofficeVideosQuery());

        return videos.videos().stream().map(response -> new HashMap<String, String>() {{
            put("id", response.id());
            put("type", response.type());
            put("title", response.title());
            put("url", response.url());
            put("courseId", response.courseId());
        }}).collect(Collectors.toList());
    }
}
