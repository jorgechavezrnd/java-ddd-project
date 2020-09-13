package tv.codely.apps.backoffice.backend.command;

import tv.codely.shared.infrastructure.cli.ConsoleCommand;

public final class FakeCommand extends ConsoleCommand {
    @Override
    public void execute(String[] args) {
        info("This is a fake command from backoffice!");
    }
}
