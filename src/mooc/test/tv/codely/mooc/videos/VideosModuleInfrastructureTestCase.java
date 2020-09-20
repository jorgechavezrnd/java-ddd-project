package tv.codely.mooc.videos;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.videos.domain.VideoRepository;
import tv.codely.mooc.videos.infrastructure.persistence.InMemoryVideoRepository;

public abstract class VideosModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    protected InMemoryVideoRepository inMemoryVideoRepository = new InMemoryVideoRepository();

    @Autowired
    protected VideoRepository         mySqlVideoRepository;

    @Autowired
    protected CourseRepository        mySqlCourseRepository;
}
