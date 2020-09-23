package tv.codely.apps.backoffice.backend.config;

import org.springframework.context.annotation.Configuration;
import tv.codely.shared.domain.bus.command.CommandBus;

@Configuration
public class BackofficeBackendServerConfiguration {
    private final CommandBus bus;

    public BackofficeBackendServerConfiguration(CommandBus bus) {
        this.bus = bus;
    }
}
