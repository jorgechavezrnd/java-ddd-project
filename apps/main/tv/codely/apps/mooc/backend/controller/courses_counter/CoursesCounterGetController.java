package tv.codely.apps.mooc.backend.controller.courses_counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class CoursesCounterGetController {
    @GetMapping("/courses-counter")
    public HashMap<String, Integer> index() {
        return new HashMap<String, Integer>() {{
            put("total", 1);
        }};
    }
}
