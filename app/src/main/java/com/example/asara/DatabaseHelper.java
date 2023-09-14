package com.example.asara;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database configuration
    private static final String DB_NAME = "asaraMShackathon";
    private static final String DB_HOST = "shobitest.database.windows.net:1433"; // e.g., "jdbc:jtds:sqlserver://your_server:1433/your_database_name"
    private static final String DB_USER = "azadmin";
    private static final String DB_PASSWORD = "Selvaraj7@";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Define your local SQLite database schema if needed
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    // Create a method to get an MSSQL database connection
    public Connection getMSSQLConnection() {
        try {
            // Load the jTDS driver
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // Create the database URL
            String dbUrl = "jdbc:jtds:sqlserver://" + DB_HOST;

            // Establish the connection with your credentials
            Connection connection = DriverManager.getConnection(dbUrl, DB_USER, DB_PASSWORD);

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Close the MSSQL connection
    public void closeMSSQLConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (java.sql.SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public List<String> retrieveDataFromTable(String tableName) {
        List<String> dataList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            try (Connection connection1 = connection = getMSSQLConnection()) {
            }
            statement = connection.createStatement();

            // Define your SQL query
            String query = "SELECT * FROM " + tableName;

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Assuming you have a column named "data_column" in your table
                String data = resultSet.getString("data_column");
                dataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of opening
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (java.sql.SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (java.sql.SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            closeMSSQLConnection(connection);
        }

        return dataList;
    }
}
