import app.Constants;
import model.ClientInfo;
import org.joda.time.LocalDate;
import util.ParseUtils;

import java.io.IOException;
import java.net.InetAddress;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Client class that invokes methods on remote object.
 */
public class Client {

    private final static int WORKING_HOURS = 8;
    private static int clientTaskExecutionTimesCounter = 0;
    private static ClientInfo client = new ClientInfo();
    private static ArrayList<Double> cpuPercentageUsageArrayList = new ArrayList<>();
    private static ArrayList<Double> memoryUsageArrayList = new ArrayList<>();

    private static double getAverageArrayValue(ArrayList<Double> values) {
        return values.stream().mapToDouble(v -> v).average().orElse(0.0);
    }

    /**
     * @param operations  Stub object for rmi
     * @param inetAddress ip address of current client
     * @throws RemoteException
     */
    private static void initializeClient(ClientOperationsProvider operations, InetAddress inetAddress) throws RemoteException {
        String username = operations.getClientUsername(inetAddress);
        String ipAddress = operations.getClientIP(inetAddress);
        LocalDate date = LocalDate.now();

        client.setSerialVersionUID();
        client.setUsername(username);
        client.setIp(ipAddress);
        client.setDate(date);
        client.setCpuPercentageUsageAverageValue(ParseUtils.truncateDoubleValueUpToTwoDecimal(getAverageArrayValue(cpuPercentageUsageArrayList)));
        client.setMemoryUsageAverageValue(ParseUtils.truncateDoubleValueUpToTwoDecimal(getAverageArrayValue(memoryUsageArrayList)));
    }

    /**
     * @param client initialized client object for storing in database.
     *               Sends client object to server.
     */
    private static void saveClientDailyStats(ClientInfo client, ClientOperationsProvider operations) throws IOException {
        operations.saveClientToDatabase(client);
    }

    public static void main(String[] args) throws IOException, NotBoundException, InterruptedException {

        Registry registry = LocateRegistry.getRegistry();
        ClientOperationsProvider operationsStub = (ClientOperationsProvider) registry.lookup("sam");
        System.err.println("Successfully connected to server.");
        InetAddress inetAddress = InetAddress.getLocalHost();

        runClientTimer(new Timer("ClientTimer"), new ClientRunnerTask(operationsStub));
        Thread.sleep(Constants.SECOND * 5);
        initializeClient(operationsStub, inetAddress);
        Thread.sleep(Constants.SECOND);
        saveClientDailyStats(client, operationsStub);

        System.out.println("operations executed");
        //Shutting down the client
        Thread.sleep(Constants.SECOND);
        Runtime.getRuntime().exit(0);
    }

    /**
     * Runs the task periodically with 0 delay.
     * @param timer timer object
     *
     * @see ClientRunnerTask
     */
    private static void runClientTimer(Timer timer, ClientRunnerTask clientTask) {
        // Feel free to use any constant for setting a period of running the task
        timer.scheduleAtFixedRate(clientTask, 0, Constants.WORKING_DAY_DURATION);
    }

    /**
     * Task for filling the arrays of cpu and memory usage throughout a day.
     */
    private static class ClientRunnerTask extends TimerTask {
        private ClientOperationsProvider operations;

        ClientRunnerTask(ClientOperationsProvider operations) {
            this.operations = operations;
        }

        @Override
        public void run() {
            while (clientTaskExecutionTimesCounter != WORKING_HOURS) {
                try {
                    cpuPercentageUsageArrayList.add(operations.getClientCpuUsage());
                    memoryUsageArrayList.add(operations.getClientMemoryUsage());
                    ++clientTaskExecutionTimesCounter;
                    Thread.sleep(Constants.HOUR);
                } catch (RemoteException e) {
                    System.err.println("Error occured while executing remote methods: " + e.getMessage());
                } catch (InterruptedException e) {
                    System.err.println("Error occured while running a task: " + e.getMessage());
                }
            }
        }
    }
}
