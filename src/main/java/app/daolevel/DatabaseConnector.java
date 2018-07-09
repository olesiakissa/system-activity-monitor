package app.daolevel;

import model.ClientInfo;

import java.util.HashSet;

public interface DatabaseConnector {

    void connectToDB();

    void insertClient(ClientInfo client);

    HashSet<String> getMonthlyClients();

    void saveMonthlyStats();

}
