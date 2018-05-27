import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Client class that invokes methods on remote object.
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        SystemOperations systemOperationsStub = (SystemOperations) registry.lookup("sam");
        System.err.println("Successfully connected to server and is ready for monitoring.");
        systemOperationsStub.analyzeSystem();
    }
}
