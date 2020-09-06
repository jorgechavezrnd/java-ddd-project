package tv.codely.mooc.students_counter.application.find;

import java.util.Objects;

public final class StudentsCounterResponse {
    private final Integer total;

    public StudentsCounterResponse(Integer total) {
        this.total = total;
    }

    public Integer total() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsCounterResponse that = (StudentsCounterResponse) o;
        return total.equals(that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
