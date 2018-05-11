package system.commands.receivers;

import model.ProcessInfo;
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
            Process p = Runtime.getRuntime().exec("tasklist");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int lineI = 0;
            while ((line = input.readLine()) != null) {
                if (++lineI > 4) {
                    ProcessAggregate.processList.add(ParseUtils.parseStringToProcess(line));
                }
            }
            input.close();

            Iterator iterator = (Iterator) new IteratorCreator().createItem();

            while (iterator.hasNext()) {
                ProcessInfo name = (ProcessInfo) iterator.next();
                System.out.println(name.getName() + "\t" + name.getPid() + "\t" + name.getSessionName() + "\t" + name.getMemory());
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

}