import app.PostgresDAO;
import app.commands.receivers.CPUIndicator;
import app.commands.receivers.MemoryIndicator;
import model.ClientInfo;
import util.ParseUtils;

import java.net.InetAddress;

/**
 * A helper class for client initialization with methods that are located on server side.
 */
public class ClientInitializer implements ClientOperationsProvider {

    private CPUIndicator cpuIndicator = new CPUIndicator();
    private MemoryIndicator memoryIndicator = new MemoryIndicator();

    @Override
    public double getClientCpuUsage() {
        return cpuIndicator.getInfo();
    }

    @Override
    public double getClientMemoryUsage() {
        return memoryIndicator.getInfo();
    }

    @Override
    public String getClientUsername(InetAddress address) {
        return ParseUtils.getClientUsername(address);
    }

    @Override
    public String getClientIP(InetAddress address) {
        return ParseUtils.getClientIPAddress(address);
    }

    @Override
    public void saveClientToDatabase(ClientInfo client)  {
        PostgresDAO daoObject = new PostgresDAO();
        daoObject.insertClient(client);
        System.err.println("Client was written to database.");
    }
}
