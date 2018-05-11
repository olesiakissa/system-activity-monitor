package system;

import system.commands.Command;
import system.commands.PrintAvailableCommandsCommand;

import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Command command = new PrintAvailableCommandsCommand();
        command.execute();

        String input;
        do {
            input = scanner.nextLine();
            InputAnalyzer analyzer = new InputAnalyzer();
            analyzer.analyze(input);
        }  while (!input.equals("q"));
        scanner.close();
    }

}
