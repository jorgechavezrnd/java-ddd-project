package tv.codely.apps.mooc.frontend.command;

import tv.codely.shared.infrastructure.cli.ConsoleCommand;

public final class FakeCommand extends ConsoleCommand {
    @Override
    public void execute(String[] args) {
        info("Fake command for mooc frontend application!");
    }
}
