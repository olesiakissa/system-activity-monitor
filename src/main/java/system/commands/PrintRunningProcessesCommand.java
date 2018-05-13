package system.commands;

import system.commands.receivers.ProcessPrinter;

/**
 * Command for printing the list of currently running windows processes.
 */
public class PrintRunningProcessesCommand implements Command {

    private ProcessPrinter processPrinter;

    public PrintRunningProcessesCommand(ProcessPrinter processPrinter) {
        this.processPrinter = processPrinter;
    }

    @Override
    public void execute() {
        this.processPrinter.printProcesses();
    }

}
