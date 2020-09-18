package tv.codely.mooc.students_counter.domain;

import tv.codely.mooc.students.domain.StudentId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StudentsCounter {
    private StudentsCounterId    id;
    private StudentsCounterTotal total;
    private List<StudentId>      existingStudents;

    public StudentsCounter(StudentsCounterId id, StudentsCounterTotal total, List<StudentId> existingStudents) {
        this.id               = id;
        this.total            = total;
        this.existingStudents = existingStudents;
    }

    private StudentsCounter() {
        this.id               = null;
        this.total            = null;
        this.existingStudents = null;
    }

    public StudentsCounterId id() {
        return id;
    }

    public StudentsCounterTotal total() {
        return total;
    }

    public List<StudentId> existingStudents() {
        return existingStudents;
    }

    public static StudentsCounter initialize(String id) {
        return new StudentsCounter(new StudentsCounterId(id), StudentsCounterTotal.initialize(), new ArrayList<>());
    }

    public boolean hasIncremented(StudentId id) {
        return existingStudents.contains(id);
    }

    public void increment(StudentId id) {
        total = total.increment();
        existingStudents.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsCounter that = (StudentsCounter) o;
        return id.equals(that.id) &&
            total.equals(that.total) &&
            existingStudents.equals(that.existingStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingStudents);
    }
}
