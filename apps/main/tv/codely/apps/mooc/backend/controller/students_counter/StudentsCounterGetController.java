package tv.codely.apps.mooc.backend.controller.students_counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.students_counter.application.find.FindStudentsCounterQuery;
import tv.codely.mooc.students_counter.application.find.StudentsCounterResponse;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;

import java.util.HashMap;

@RestController
public final class StudentsCounterGetController {
    QueryBus bus;

    public StudentsCounterGetController(QueryBus bus) {
        this.bus = bus;
    }

    @GetMapping("/students-counter")
    public HashMap<String, Integer> index() throws QueryHandlerExecutionError {
        StudentsCounterResponse response = bus.ask(new FindStudentsCounterQuery());

        return new HashMap<String, Integer>() {{
            put("total", response.total());
        }};
    }
}
