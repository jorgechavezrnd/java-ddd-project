package tv.codely.apps.backoffice.frontend.controller.videos;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import tv.codely.mooc.videos.application.create.CreateVideoCommand;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.infrastructure.validation.ValidationResponse;
import tv.codely.shared.infrastructure.validation.Validator;

import java.io.Serializable;
import java.util.HashMap;

@Controller
public final class VideosPostWebController {
    private final CommandBus bus;
    private final HashMap<String, String> rules = new HashMap<String, String>() {{
        put("id", "required|not_empty|uuid");
        put("type", "required|not_empty|string");
        put("title", "required|not_empty|string");
        put("url", "required|not_empty|string");
        put("courseId", "required|not_empty|uuid");
    }};

    public VideosPostWebController(CommandBus bus) {
        this.bus = bus;
    }

    @PostMapping(value = "/videos", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView index(
        @RequestParam HashMap<String, Serializable> request,
        RedirectAttributes attributes
    ) throws Exception {
        ValidationResponse validationResponse = Validator.validate(request, rules);

        return validationResponse.hasErrors()
            ? redirectWithErrors(validationResponse, request, attributes)
            : createVideo(request);
    }

    private RedirectView redirectWithErrors(
        ValidationResponse validationResponse,
        HashMap<String, Serializable> request,
        RedirectAttributes attributes
    ) {
        attributes.addFlashAttribute("errors", validationResponse.errors());
        attributes.addFlashAttribute("inputs", request);

        return new RedirectView("/videos");
    }

    private RedirectView createVideo(HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
        bus.dispatch(new CreateVideoCommand(
            request.get("id").toString(),
            request.get("type").toString(),
            request.get("title").toString(),
            request.get("url").toString(),
            request.get("courseId").toString()
        ));

        return new RedirectView("/videos");
    }
}
