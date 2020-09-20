package tv.codely.mooc.videos_counter;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.videos_counter.domain.VideosCounterRepository;

public abstract class VideosCounterModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    @Autowired
    protected CourseRepository        courseRepository;

    @Autowired
    protected VideosCounterRepository videosCounterRepository;
}
