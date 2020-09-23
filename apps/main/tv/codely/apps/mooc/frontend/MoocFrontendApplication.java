package tv.codely.apps.mooc.frontend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.shared.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"tv.codely.shared", "tv.codely.mooc", "tv.codely.apps.mooc.frontend"}
)
public class MoocFrontendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>();
    }
}
