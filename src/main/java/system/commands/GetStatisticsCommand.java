package system.commands;

import system.commands.receivers.StatisticsCalculator;

/**
 * Command for calculating stats.
 */
public class GetStatisticsCommand implements Command {

    private StatisticsCalculator calculator;

    public GetStatisticsCommand(StatisticsCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        this.calculator.calculate();
    }
}
