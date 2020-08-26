package tv.codely.app.mooc.controller.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.students.application.create.StudentCreator;

@RestController
public final class StudentsPutController {
    private StudentCreator creator;

    public StudentsPutController(StudentCreator creator) {
        this.creator = creator;
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> create(@PathVariable String id, @RequestBody Request request) {
        creator.create(id, request.name(), request.email());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

final class Request {
    private String name;
    private String email;

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
