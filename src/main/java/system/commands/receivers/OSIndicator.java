package system.commands.receivers;

import model.OS;

public class OSIndicator {

    public void displayInfo() {
        OS os = new OS();
        System.out.println(os.toString());
    }

}
