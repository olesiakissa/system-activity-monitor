package app;

import model.ClientInfo;

public interface DatabaseConnector {

    void connectToDB();

    void insertClient(ClientInfo client);

}
