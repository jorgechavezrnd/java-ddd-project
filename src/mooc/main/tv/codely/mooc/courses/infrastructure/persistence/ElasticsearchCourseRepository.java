package tv.codely.mooc.courses.infrastructure.persistence;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.domain.criteria.Filter;
import tv.codely.shared.domain.criteria.Filters;
import tv.codely.shared.domain.criteria.Order;
import tv.codely.shared.infrastructure.elasticsearch.ElasticsearchClient;
import tv.codely.shared.infrastructure.elasticsearch.ElasticsearchRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@Service
public final class ElasticsearchCourseRepository extends ElasticsearchRepository<Course> implements CourseRepository {
    public ElasticsearchCourseRepository(ElasticsearchClient client) {
        super(client);
    }

    @Override
    public void save(Course course) {
        persist(course.id().value(), course.toPrimitives());
    }

    @Override
    public Optional<Course> search(CourseId id) {
        Filter idFilter = Filter.create("id", "equal", id.value());
        Criteria criteria = new Criteria(new Filters(Collections.singletonList(idFilter)), Order.asc("id"));

        return searchByCriteria(criteria, Course::fromPrimitives).stream().findFirst();
    }

    @Override
    protected String moduleName() {
        return "courses";
    }
}
