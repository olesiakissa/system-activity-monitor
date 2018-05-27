package app.commands.receivers;

import model.OS;

public class OSIndicator implements Indicator {

    @Override
    public void displayInfo() {
        OS os = new OS();
        System.out.println(os.toString());
    }

}
