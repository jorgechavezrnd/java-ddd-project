package tv.codely.apps.backoffice.frontend.controller.students;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import tv.codely.mooc.students.application.create.CreateStudentCommand;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.infrastructure.validation.ValidationResponse;
import tv.codely.shared.infrastructure.validation.Validator;

import java.io.Serializable;
import java.util.HashMap;

@Controller
public final class StudentsPostWebController {
    private final CommandBus bus;
    private final HashMap<String, String> rules = new HashMap<String, String>() {{
        put("id", "required|not_empty|uuid");
        put("name", "required|not_empty|string");
        put("surname", "required|not_empty|string");
        put("email", "required|not_empty|string");
    }};

    public StudentsPostWebController(CommandBus bus) {
        this.bus = bus;
    }

    @PostMapping(value = "/students", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView index(
        @RequestParam HashMap<String, Serializable> request,
        RedirectAttributes attributes
    ) throws Exception {
        ValidationResponse validationResponse = Validator.validate(request, rules);

        return validationResponse.hasErrors()
            ? redirectWithErrors(validationResponse, request, attributes)
            : createStudent(request);
    }

    private RedirectView redirectWithErrors(
        ValidationResponse validationResponse,
        HashMap<String, Serializable> request,
        RedirectAttributes attributes
    ) {
        attributes.addFlashAttribute("errors", validationResponse.errors());
        attributes.addFlashAttribute("inputs", request);

        return new RedirectView("/students");
    }

    private RedirectView createStudent(HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
        bus.dispatch(new CreateStudentCommand(
            request.get("id").toString(),
            request.get("name").toString(),
            request.get("surname").toString(),
            request.get("email").toString()
        ));

        return new RedirectView("/students");
    }
}
