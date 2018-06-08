package app.commands.receivers;

import model.OS;

public class OSIndicator {

    public OS displayInfo() {
        OS os = new OS();
        System.out.println(os.toString());
        return os;
    }

}
