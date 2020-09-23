package tv.codely.apps.backoffice.frontend.command;

import tv.codely.backoffice.courses.infrastructure.persistence.ElasticsearchBackofficeCourseRepository;
import tv.codely.backoffice.courses.infrastructure.persistence.MySqlBackofficeCourseRepository;
import tv.codely.shared.infrastructure.cli.ConsoleCommand;

public final class MigrateCoursesFromMySqlToElasticsearchCommand extends ConsoleCommand {
    private final MySqlBackofficeCourseRepository         mysqlRepository;
    private final ElasticsearchBackofficeCourseRepository elasticsearchRepository;

    public MigrateCoursesFromMySqlToElasticsearchCommand(
        MySqlBackofficeCourseRepository mysqlRepository,
        ElasticsearchBackofficeCourseRepository elasticsearchRepository
    ) {
        this.mysqlRepository         = mysqlRepository;
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @Override
    public void execute(String[] args) {
        mysqlRepository.searchAll().forEach(elasticsearchRepository::save);
    }
}
