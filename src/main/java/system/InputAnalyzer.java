package system;

import system.commands.*;
import system.commands.receivers.*;

/**
 * Invoker class for commands.
 */
public class InputAnalyzer {
    private Command command;

    public void analyze(String input) {

        switch (input) {
            case "pr -all":
                command = new PrintRunningProcessesCommand(new ProcessPrinter());
                command.execute();
                break;
            case "-os":
                command = new GetOSInfoCommand(new OSIndicator());
                command.execute();
                break;
            case "-cpu":
                command = new GetCpuUsageCommand(new CPUIndicator());
                command.execute();
                break;
            case "-mem":
                command = new GetMemoryUsageCommand(new MemoryIndicator());
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
