import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for methods invoking.
 */
public interface SystemOperations extends Remote {

    void analyzeSystem() throws RemoteException;

}
