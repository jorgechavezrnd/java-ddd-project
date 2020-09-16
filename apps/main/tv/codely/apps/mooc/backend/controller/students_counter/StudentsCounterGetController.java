package tv.codely.apps.mooc.backend.controller.students_counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.students_counter.application.find.StudentsCounterFinder;
import tv.codely.mooc.students_counter.application.find.StudentsCounterResponse;

import java.util.HashMap;

@RestController
public final class StudentsCounterGetController {
    StudentsCounterFinder finder;

    public StudentsCounterGetController(StudentsCounterFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/students-counter")
    public HashMap<String, Integer> index() {
        StudentsCounterResponse response = finder.find();

        return new HashMap<String, Integer>() {{
            put("total", response.total());
        }};
    }
}
