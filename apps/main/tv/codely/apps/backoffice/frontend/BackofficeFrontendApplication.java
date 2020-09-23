package tv.codely.apps.backoffice.frontend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.apps.backoffice.frontend.command.MigrateCoursesFromMySqlToElasticsearchCommand;
import tv.codely.shared.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"tv.codely.shared", "tv.codely.backoffice", "tv.codely.mooc", "tv.codely.apps.backoffice.frontend"}
)
public class BackofficeFrontendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
            put("migrate_courses_from_mysql_to_elasticsearch", MigrateCoursesFromMySqlToElasticsearchCommand.class);
        }};
    }
}
