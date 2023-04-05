package com.codecool.marsexploration.helpers;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static Connection init(String mapName) {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        Connection connection = getConnection(url, user, password);
        dropTable(connection,mapName);
        createTable(connection, mapName);
        return connection;
    }

    private static Connection getConnection(String url, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to " + url.split("/")[0] + " database!");
            return connection;
        } catch (SQLException ex) {
            System.err.println("Could not create database connection.");
            throw new RuntimeException(ex);
        }
    }

    private static void createTable(Connection connection, String mapName) {
        try{
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + mapName + "(" +
                    "step_id INTEGER," +
                    "event_type TEXT," +
                    "unit_name TEXT," +
                    "position_x INTEGER," +
                    "position_y INTEGER" +
                    ");";
            statement.executeUpdate(createTableQuery);
        }catch (SQLException ex) {
            System.out.println("Could not create table");
            throw new RuntimeException(ex);
        }
    }

    private static void dropTable(Connection connection, String tableName) {
        try{
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + tableName + ";");
            System.out.println("Table " + tableName + " dropped successfully");
        } catch (SQLException e) {
            System.err.println("Error dropping table " + tableName + ": " + e.getMessage());
        }
    }

    public static void logInsert(Connection connection, String mapName, int stepId, String eventType, String unitName, int positionX, int positionY) throws SQLException {
        Statement statement = connection.createStatement();
        String insertQuery = "INSERT INTO " + mapName +"(step_id, event_type, unit_name, position_x, position_y) " +
                "VALUES (" + stepId + ", '" + eventType + "', '" + unitName + "', " + positionX + ", " + positionY + ")" ;
        statement.executeUpdate(insertQuery);
    }
}
