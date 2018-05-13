package system;

import system.commands.Command;
import system.commands.PrintAvailableCommandsCommand;

import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printAvailableCommands();

        String input;
        do {
            input = scanner.nextLine();
            InputAnalyzer analyzer = new InputAnalyzer();
            analyzer.analyze(input);
        }  while (!input.equals("q"));
        scanner.close();
    }

    private static void printAvailableCommands() {
        System.out.println("Please, enter a command from a list of available commands: ");
        Command command = new PrintAvailableCommandsCommand();
        command.execute();
    }

}
