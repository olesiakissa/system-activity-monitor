package system;

import system.commands.Command;
import system.commands.GetOSInfoCommand;
import system.commands.GetStatisticsCommand;
import system.commands.PrintRunningProcessesCommand;
import system.commands.receivers.OSIndicator;
import system.commands.receivers.ProcessPrinter;
import system.commands.receivers.StatisticsCalculator;

/**
 * Invoker class for commands.
 */
public class InputAnalyzer {
    private Command command;

    public void analyze(String input) {
        switch (input) {
            case "tasklist":
                command = new PrintRunningProcessesCommand(new ProcessPrinter());
                command.execute();
                break;
            case "stats":
                command = new GetStatisticsCommand(new StatisticsCalculator());
                command.execute();
                break;
            case "os":
                command = new GetOSInfoCommand(new OSIndicator());
                command.execute();
                break;
            case "q":
                System.out.println("Bye-bye!");
                break;
            default:
                command = new PrintRunningProcessesCommand(new ProcessPrinter());
                command.execute();
                break;
        }
    }
}
