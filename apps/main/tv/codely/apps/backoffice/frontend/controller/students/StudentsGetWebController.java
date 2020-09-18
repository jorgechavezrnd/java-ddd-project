package tv.codely.apps.backoffice.frontend.controller.students;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import tv.codely.mooc.students_counter.application.find.FindStudentsCounterQuery;
import tv.codely.mooc.students_counter.application.find.StudentsCounterResponse;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

@Controller
public final class StudentsGetWebController {
    private final QueryBus bus;

    public StudentsGetWebController(QueryBus bus) {
        this.bus = bus;
    }

    @GetMapping("/students")
    public ModelAndView index(
        @ModelAttribute("inputs") HashMap<String, Serializable> inputs,
        @ModelAttribute("errors") HashMap<String, Serializable> errors
    ) throws QueryHandlerExecutionError {
        try {
            StudentsCounterResponse counterResponse = bus.ask(new FindStudentsCounterQuery());

            return new ModelAndView("pages/students/students", new HashMap<String, Serializable>() {{
                put("title", "Students");
                put("description", "Students CodelyTV - Backoffice");
                put("students_counter", counterResponse.total());
                put("inputs", inputs);
                put("errors", errors);
                put("generated_uuid", UUID.randomUUID().toString());
            }});
        } catch (Exception e) {
            return new ModelAndView("pages/students/students", new HashMap<String, Serializable>() {{
                put("title", "Students");
                put("description", "Students CodelyTV - Backoffice");
                put("students_counter", 0);
                put("inputs", inputs);
                put("errors", errors);
                put("generated_uuid", UUID.randomUUID().toString());
            }});
        }
    }
}
