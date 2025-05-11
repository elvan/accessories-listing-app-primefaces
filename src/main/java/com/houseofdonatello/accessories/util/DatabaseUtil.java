package com.houseofdonatello.accessories.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Utility class for database operations
 */
public class DatabaseUtil {
    
    private static final String PROPERTY_FILE = "/db.properties";
    private static DataSource dataSource;
    
    static {
        try {
            Properties props = new Properties();
            InputStream inputStream = DatabaseUtil.class.getResourceAsStream(PROPERTY_FILE);
            
            if (inputStream != null) {
                props.load(inputStream);
                
                BasicDataSource ds = new BasicDataSource();
                ds.setDriverClassName(props.getProperty("db.driver"));
                ds.setUrl(props.getProperty("db.url"));
                ds.setUsername(props.getProperty("db.username"));
                ds.setPassword(props.getProperty("db.password"));
                
                // Set connection pool properties
                ds.setInitialSize(Integer.parseInt(props.getProperty("db.pool.initialSize", "5")));
                ds.setMinIdle(Integer.parseInt(props.getProperty("db.pool.minIdle", "5")));
                ds.setMaxIdle(Integer.parseInt(props.getProperty("db.pool.maxIdle", "10")));
                ds.setMaxTotal(Integer.parseInt(props.getProperty("db.pool.maxTotal", "25")));
                
                dataSource = ds;
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load database properties", e);
        }
    }
    
    /**
     * Get a database connection from the connection pool
     * @return Connection - A connection to the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource is not initialized");
        }
        return dataSource.getConnection();
    }
    
    /**
     * Close the database connection
     * @param connection The database connection to close
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
