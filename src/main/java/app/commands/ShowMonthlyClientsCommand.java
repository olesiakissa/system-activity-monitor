package app.commands;

import app.DatabaseConnector;

/**
 * Command for printing the list of clients (list of their IP addresses) within network per month.
 */
public class ShowMonthlyClientsCommand implements Command {

    private DatabaseConnector dao;

    public ShowMonthlyClientsCommand(DatabaseConnector databaseConnector) {
        this.dao = databaseConnector;
    }

    @Override
    public void execute() {
        System.out.println("\t\t\tLIST OF CLIENTS: ");
        this.dao.getMonthlyClients();
    }

}
