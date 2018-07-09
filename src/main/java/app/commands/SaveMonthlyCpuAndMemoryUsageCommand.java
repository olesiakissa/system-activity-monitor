package app.commands;

import app.daolevel.DatabaseConnector;

/**
 * Command for saving the values of memory and cpu usage for all clients per month.
 */
public class SaveMonthlyCpuAndMemoryUsageCommand implements Command {

    private DatabaseConnector dao;

    public SaveMonthlyCpuAndMemoryUsageCommand(DatabaseConnector databaseConnector) {
        this.dao = databaseConnector;
    }

    @Override
    public void execute() {
        this.dao.saveMonthlyStats();
        System.err.println("The stats were saved to database.");
    }

}
