package tv.codely.apps.backoffice.frontend.controller.videos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import tv.codely.backoffice.courses.application.BackofficeCourseResponse;
import tv.codely.backoffice.courses.application.BackofficeCoursesResponse;
import tv.codely.backoffice.courses.application.search_all.SearchAllBackofficeCoursesQuery;
import tv.codely.mooc.videos_counter.application.VideosCounterResponse;
import tv.codely.mooc.videos_counter.application.sum_all.SumAllVideosCounterQuery;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public final class VideosGetWebController {
    private final QueryBus bus;

    public VideosGetWebController(QueryBus bus) {
        this.bus = bus;
    }

    @GetMapping("/videos")
    public ModelAndView index(
        @ModelAttribute("inputs") HashMap<String, Serializable> inputs,
        @ModelAttribute("errors") HashMap<String, List<String>> errors
    ) throws QueryHandlerExecutionError {
        VideosCounterResponse counterResponse = bus.ask(new SumAllVideosCounterQuery());
        BackofficeCoursesResponse courses = bus.ask(new SearchAllBackofficeCoursesQuery());

        return new ModelAndView("pages/videos/videos", new HashMap<String, Serializable>() {{
            put("title", "Videos");
            put("description", "Courses CodelyTV - Backoffice");
            put("videos_counter", counterResponse.total());
            put("inputs", inputs);
            put("errors", errors);
            put("generated_uuid", UUID.randomUUID().toString());
            put("course_ids", courses.courses().stream().map(BackofficeCourseResponse::id).toArray());
        }});
    }
}
