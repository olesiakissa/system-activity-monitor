package system.commands;

import system.commands.receivers.OSIndicator;

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
