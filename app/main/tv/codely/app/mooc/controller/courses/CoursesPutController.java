package tv.codely.app.mooc.controller.courses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.courses.application.create.CourseCreator;

@RestController
public final class CoursesPutController {
    private CourseCreator creator;

    public CoursesPutController(CourseCreator creator) {
        this.creator = creator;
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity create(@PathVariable String id, @RequestBody Request request) {
        creator.create(id, request.name(), request.duration());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

final class Request {
    private String name;
    private String duration;

    String name() {
        return name;
    }

    String duration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }
}
