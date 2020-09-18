package tv.codely.mooc.students.application.create;

import tv.codely.shared.domain.bus.command.Command;

import java.util.Objects;

public final class CreateStudentCommand implements Command {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;

    public CreateStudentCommand(String id, String name, String surname, String email) {
        this.id      = id;
        this.name    = name;
        this.surname = surname;
        this.email   = email;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateStudentCommand request = (CreateStudentCommand) o;
        return id.equals(request.id) &&
            name.equals(request.name) &&
            surname.equals(request.surname) &&
            email.equals(request.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }
}
