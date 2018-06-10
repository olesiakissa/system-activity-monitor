package app;

import model.ClientInfo;
import util.ParseUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.UUID;

/**
 * This class provides methods for creating connection to database and making queries.
 */
public class PostgresDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PostgresDAO() {
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
                dburl = prop.getProperty("dburl");
                dbuser = prop.getProperty("dbusername");
                dbpassword = prop.getProperty("dbpassword");
            } catch (FileNotFoundException e) {
                System.err.println("Could not find config file: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Could not read config file: " + e.getMessage());
            }
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
            System.err.printf("Opened connection on %s\n", dburl);
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

    //TODO add methods for selecting clients from table that contains monthly stats
    //TODO add methods for calculating average usage of memory and cpu per month for each client
}
