package system.commands;

import system.commands.receivers.MemoryIndicator;

/**
 * Command for printing info about physical and virtual memory.
 */
public class GetMemoryUsageCommand implements Command {

    private MemoryIndicator indicator;

    public GetMemoryUsageCommand(MemoryIndicator indicator) {
        this.indicator = indicator;
    }

    @Override
    public void execute() {
        this.indicator.displayInfo();
    }

}
