package tv.codely.mooc.students_counter.application.find;

import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Service
public final class FindStudentsCounterQueryHandler implements QueryHandler<FindStudentsCounterQuery, StudentsCounterResponse> {
    private final StudentsCounterFinder finder;

    public FindStudentsCounterQueryHandler(StudentsCounterFinder finder) {
        this.finder = finder;
    }

    @Override
    public StudentsCounterResponse handle(FindStudentsCounterQuery query) {
        return finder.find();
    }
}
