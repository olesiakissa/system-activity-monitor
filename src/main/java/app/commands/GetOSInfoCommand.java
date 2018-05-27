package app.commands;

import app.commands.receivers.OSIndicator;

/**
 * Command for printing info about os architecture.
 */
public class GetOSInfoCommand implements Command {

    private OSIndicator osIndicator;

    public GetOSInfoCommand(OSIndicator osIndicator) {
        this.osIndicator = osIndicator;
    }

    @Override
    public void execute() {
        this.osIndicator.displayInfo();
    }

}
