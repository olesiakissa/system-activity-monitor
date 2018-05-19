package system.commands.receivers;

import model.ProcessInfo;
import system.Constants;
import system.Iterator;
import system.ProcessAggregate;
import system.factory.creators.IteratorCreator;
import util.ParseUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Prints the list of currently running windows processes.
 */
public class ProcessPrinter {

    public void printProcesses() {
        try {
            String line;
            Process p = Runtime.getRuntime().exec(Constants.WINDOWS_TASKLIST);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int lineI = 0;
            while ((line = input.readLine()) != null) {
                if (++lineI > Constants.WINDOWS_PROCESS_UNNECESSARY_PROCESS_LINE_SIZE) {
                    ProcessAggregate.processList.add(ParseUtils.parseStringToProcess(line));
                }
            }
            input.close();

            Iterator iterator = (Iterator) new IteratorCreator().createItem();

            while (iterator.hasNext()) {
                ProcessInfo process = (ProcessInfo) iterator.next();
                System.out.printf("NAME: %s \tPID: %d \tSESSION NAME: %s \tSESSION#: %d \tMEM USAGE: %d K\n",
                        process.getName(), process.getPid(), process.getSessionName(), process.getSessionNumber(), process.getMemory());
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

}