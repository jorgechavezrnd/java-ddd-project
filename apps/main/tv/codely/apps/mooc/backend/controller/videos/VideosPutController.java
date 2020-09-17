package tv.codely.apps.mooc.backend.controller.videos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.videos.application.create.CreateVideoCommand;
import tv.codely.shared.domain.bus.command.CommandBus;

@RestController
public final class VideosPutController {
    private final CommandBus bus;

    public VideosPutController(CommandBus bus) {
        this.bus = bus;
    }

    @PutMapping("/videos/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) {
        bus.dispatch(new CreateVideoCommand(id, request.type(), request.title(), request.url(), request.courseId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

final class Request {
    private String type;
    private String title;
    private String url;
    private String courseId;

    public String type() {
        return type;
    }

    public String title() {
        return title;
    }

    public String url() {
        return url;
    }

    public String courseId() {
        return courseId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
