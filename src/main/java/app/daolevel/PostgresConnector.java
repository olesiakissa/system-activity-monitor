package app.daolevel;

import model.ClientInfo;
import util.ParseUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

import static util.ParseUtils.truncateDoubleValueUpToTwoDecimal;

/**
 * This class provides methods for creating connection to database and making queries.
 */
public class PostgresConnector implements DatabaseConnector {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PostgresConnector() {
        connectToDB();
    }

    public void connectToDB() {
        try {
            String dburl = "";
            String dbuser = "";
            String dbpassword = "";
            try (InputStream resourceStream = ClassLoader.getSystemResourceAsStream("config.properties")) {
                Properties prop = new Properties();
                prop.load(resourceStream);
                dburl = prop.getProperty("pg_dburl");
                dbuser = prop.getProperty("pg_dbusername");
                dbpassword = prop.getProperty("pg_dbpassword");
            } catch (FileNotFoundException e) {
                System.err.println("Could not find config file: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Could not read config file: " + e.getMessage());
            }
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
        } catch (SQLException e) {
            System.err.println("Could not connect to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Closes connection. In case of success prints out that the connection was closed.
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        connection.close();
        System.out.println("Connection closed.");
    }

    /**
     * @param client ClientInfo object to insert to database.
     */
    public void insertClient(ClientInfo client) {
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO samdb.sam_dev.clients_info(ip, username, date, cpu_usage_value, memory_usage_value, uuid) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, client.getIp());
            preparedStatement.setString(2, client.getUsername());
            preparedStatement.setDate(  3, ParseUtils.jodaLocalDateToDate(client.getDate()));
            preparedStatement.setDouble(4, client.getCpuPercentageUsageAverageValue());
            preparedStatement.setDouble(5, client.getMemoryUsageAverageValue());
            preparedStatement.setObject(6, client.getUuid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error occured while inserting client to database: " + e.getMessage());
        }
    }

    /**
     * Selects all the clients within the network per month.
     * @return list with clients per month
     */
    public HashSet<String> getMonthlyClients() {
        HashSet<String> monthlyClientsHashSet = new HashSet<>();
        try {
            String query = "SELECT sam_dev.clients_info.ip FROM sam_dev.clients_info\n" +
                    "GROUP BY sam_dev.clients_info.ip\n" +
                    "ORDER BY sam_dev.clients_info.ip ASC";
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                monthlyClientsHashSet.add(rs.getString("ip"));
            }
        } catch (SQLException e) {
            System.err.println("Error occured while selecting data from 'clients_info' table: " + e.getMessage());
        }
        monthlyClientsHashSet.forEach(System.out::println);
        return monthlyClientsHashSet;
    }

    /**
     * @param userIP IP address of user to check his usage of cpu.
     * @return cpu usage value per month
     */
    public double getClientAverageCpuMonthlyUsage(String userIP) {
        HashMap<String, Double> clientStatsHashMap = new HashMap<>();
        try {
            String query = "SELECT sam_dev.clients_info.ip, sam_dev.clients_info.cpu_usage_value " +
            "FROM sam_dev.clients_info " +
            "WHERE sam_dev.clients_info.ip = \'" + userIP + "\'";
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                clientStatsHashMap.put(rs.getString("ip"), rs.getDouble("cpu_usage_value"));
            }
        } catch (SQLException e) {
            System.err.println("Error occured while selecting data from 'clients_info' table: " + e.getMessage());
        }
        return clientStatsHashMap.values().stream().mapToDouble(v -> v).average().orElse(0.0);
    }

    /**
     * @param userIP IP address of user to check his usage of cpu.
     * @return memory usage value per month
     */
    public double getClientAverageMemoryMonthlyUsage(String userIP) {
        HashMap<String, Double> clientStatsHashMap = new HashMap<>();
        try {
            String query = "SELECT sam_dev.clients_info.ip, sam_dev.clients_info.memory_usage_value " +
                    "FROM sam_dev.clients_info " +
                    "WHERE sam_dev.clients_info.ip = \'" + userIP + "\'";
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                clientStatsHashMap.put(rs.getString("ip"), rs.getDouble("memory_usage_value"));
            }
        } catch (SQLException e) {
            System.err.println("Error occured while selecting data from 'clients_info' table: " + e.getMessage());
        }
        return clientStatsHashMap.values().stream().mapToDouble(v -> v).average().orElse(0.0);
    }

    /**
     * Saves information about clients cpu and memory usage to database.
     */
    public void saveMonthlyStats() {
        try {
            String query = "SELECT sam_dev.clients_info.ip, AVG (sam_dev.clients_info.memory_usage_value) AS avg_mem, AVG (sam_dev.clients_info.cpu_usage_value) AS avg_cpu\n" +
                    "FROM sam_dev.clients_info\n" +
                    "GROUP BY sam_dev.clients_info.ip";
            preparedStatement = connection.prepareStatement(query);
            ResultSet selectResultSet = preparedStatement.executeQuery();
            PreparedStatement insertFetchedDataPreparedStatement = connection.prepareStatement(
                    "INSERT INTO samdb.sam_dev.clients_monthly_stats(cpu_monthly_usage, memory_monthly_usage, client_ip) VALUES(?,?,?)");
            insertFetchedDataPreparedStatement.setDouble(1, truncateDoubleValueUpToTwoDecimal(selectResultSet.getDouble("avg_cpu")));
            insertFetchedDataPreparedStatement.setDouble(2, truncateDoubleValueUpToTwoDecimal(selectResultSet.getDouble("avg_mem")));
            insertFetchedDataPreparedStatement.setString(3, selectResultSet.getString("ip"));
            insertFetchedDataPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error occured while inserting data to 'clients_monthly_stats' table: " + e.getMessage());
        }
    }

}
