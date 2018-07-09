package app;

import app.commands.*;
import app.commands.receivers.*;
import app.daolevel.DatabaseConnector;
import app.daolevel.PostgresConnector;

/**
 * Invoker class for commands.
 */
public class InputAnalyzer {
    private Command command;
    private DatabaseConnector dao = new PostgresConnector();

    public void analyze(String input) {

        switch (input) {
            case "pr -a":
                command = new PrintRunningProcessesCommand(new ProcessPrinter());
                command.execute();
                break;
            case "os":
                command = new GetOSInfoCommand(new OSIndicator());
                command.execute();
                break;
            case "cpu":
                command = new GetCpuUsageCommand(new CPUIndicator());
                command.execute();
                break;
            case "mem":
                command = new GetMemoryUsageCommand(new MemoryIndicator());
                command.execute();
                break;
            case "show cl":
                command = new ShowMonthlyClientsCommand(dao);
                command.execute();
                break;
            case "save st":
                command = new SaveMonthlyCpuAndMemoryUsageCommand(dao);
                command.execute();
                break;
            case "q":
                System.err.println("Disconnected from server. Monitoring stopped.");
                break;
            default:
                System.err.println("Wrong input.Check available commands: ");
                command = new PrintAvailableCommandsCommand();
                command.execute();
                break;
        }
        
    }
}
