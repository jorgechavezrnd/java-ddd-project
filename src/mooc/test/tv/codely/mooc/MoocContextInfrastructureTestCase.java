package tv.codely.mooc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.mooc.backend.MoocBackendApplication;
import tv.codely.mooc.courses.ElasticsearchEnvironmentArranger;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

import java.io.IOException;

@ContextConfiguration(classes = MoocBackendApplication.class)
@SpringBootTest
public abstract class MoocContextInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    private ElasticsearchEnvironmentArranger elasticsearchArranger;

    protected void clearElasticsearch() throws IOException {
        elasticsearchArranger.arrange("mooc", "mooc_courses");
    }
}
