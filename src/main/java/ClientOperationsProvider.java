import model.ClientInfo;

import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Server class with methods that are accessible for client machines.
 */
public interface ClientOperationsProvider extends Remote {

    double getClientCpuUsage() throws RemoteException;

    double getClientMemoryUsage() throws RemoteException;

    String getClientUsername(InetAddress address) throws RemoteException;

    String getClientIP(InetAddress address) throws RemoteException;

    void saveClientToDatabase(ClientInfo client) throws RemoteException;
}
