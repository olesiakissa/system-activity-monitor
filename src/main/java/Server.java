import app.Constants;
import app.InputAnalyzer;
import app.commands.Command;
import app.commands.PrintAvailableCommandsCommand;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Server class that contains the 'remote' object which will be invoked by client.
 */
public class Server implements SystemOperations {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Creates and exports a new UnicastRemoteObject object using an
     * anonymous port.
     *
     * @throws RemoteException if failed to export object
     */
    Server() throws RemoteException {
    }

    //region sysadmin manual operations
    @Override
    public void analyzeSystem() {
        printAvailableCommands();

        String input;
        do {
            input = scanner.nextLine();
            InputAnalyzer analyzer = new InputAnalyzer();
            analyzer.analyze(input);
        } while (!input.equals("q"));
        scanner.reset();
    }

    private void printAvailableCommands() {
        System.out.println("Please, enter a command from a list of available commands: ");
        Command command = new PrintAvailableCommandsCommand();
        command.execute();
    }
    //endregion


    public static void main(String[] args) {
        /* To invoke the same methods on the server machine for system administrating
        just create a separate thread for inputAnalyze() method.
        */
        connectToRmiRegistry();
    }

    private static void connectToRmiRegistry() {
        try {
            ClientOperationsProvider serverObject = new ClientInitializer();
            ClientOperationsProvider operationsStub = (ClientOperationsProvider) UnicastRemoteObject.exportObject(serverObject, Constants.ANY_FREE_PORT);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("sam", operationsStub);
            System.err.println("Server started successfully.");
        } catch (RemoteException e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
