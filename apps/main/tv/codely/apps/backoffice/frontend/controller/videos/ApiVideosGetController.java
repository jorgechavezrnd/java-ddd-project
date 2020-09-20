package tv.codely.apps.backoffice.frontend.controller.videos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.backoffice.videos.application.BackofficeVideosResponse;
import tv.codely.backoffice.videos.application.search_by_criteria.SearchBackofficeVideosByCriteriaQuery;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public final class ApiVideosGetController {
    private final QueryBus bus;

    public ApiVideosGetController(QueryBus bus) {
        this.bus = bus;
    }

    @GetMapping("/api/videos")
    public List<HashMap<String, String>> index(@RequestParam HashMap<String, Serializable> params) throws QueryHandlerExecutionError {
        BackofficeVideosResponse videos = bus.ask(
            new SearchBackofficeVideosByCriteriaQuery(
                parseFilters(params),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
            )
        );

        return videos.videos().stream().map(response -> new HashMap<String, String>() {{
            put("id", response.id());
            put("type", response.type());
            put("title", response.title());
            put("url", response.url());
            put("courseId", response.courseId());
        }}).collect(Collectors.toList());
    }

    private List<HashMap<String, String>> parseFilters(HashMap<String, Serializable> params) {
        int maxParams = params.size();

        List<HashMap<String, String>> filters = new ArrayList<>();

        for (int possibleFilterKey = 0; possibleFilterKey < maxParams; possibleFilterKey++) {
            if (params.containsKey(String.format("filters[%s][field]", possibleFilterKey))) {
                int key = possibleFilterKey;

                filters.add(new HashMap<String, String>() {{
                    put("field", (String) params.get(String.format("filters[%s][field]", key)));
                    put("operator", (String) params.get(String.format("filters[%s][operator]", key)));
                    put("value", (String) params.get(String.format("filters[%s][value]", key)));
                }});
            }
        }

        return filters;
    }
}
