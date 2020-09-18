package tv.codely.apps.mooc.backend.controller.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.students.application.create.CreateStudentCommand;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;

@RestController
public final class StudentsPutController {
    private final CommandBus bus;

    public StudentsPutController(CommandBus bus) {
        this.bus = bus;
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        bus.dispatch(new CreateStudentCommand(id, request.name(), request.surname(), request.email()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

final class Request {
    private String name;
    private String surname;
    private String email;

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
