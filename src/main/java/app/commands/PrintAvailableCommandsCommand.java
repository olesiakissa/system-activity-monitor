package app.commands;

import util.FileUtils;

/**
 * Command for printing the list of available commands.
 */
public class PrintAvailableCommandsCommand implements Command {

    private FileUtils commandsPrinter = new FileUtils();

    @Override
    public void execute() {
        this.commandsPrinter.readCommandsFile();
    }

}
