package com.codecool.marsexploration.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class DatabaseManager {
    private Connection conn;

    public DatabaseManager(String filename) {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Create a connection to the database
            conn = DriverManager.getConnection("jdbc:sqlite:" + "mars-exploration.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTables() {
        try (Statement stmt = conn.createStatement()) {
            // Create the tables
            stmt.executeUpdate("CREATE TABLE rovers (id INTEGER PRIMARY KEY, name TEXT NOT NULL, resources_extracted INTEGER NOT NULL DEFAULT 0)");
            stmt.executeUpdate("CREATE TABLE command_centers (id INTEGER PRIMARY KEY, name TEXT NOT NULL, resources_delivered INTEGER NOT NULL DEFAULT 0, resources_stock INTEGER NOT NULL DEFAULT 0)");
            stmt.executeUpdate("CREATE TABLE constructions (id INTEGER PRIMARY KEY, name TEXT NOT NULL, resources_used INTEGER NOT NULL DEFAULT 0, command_center_id INTEGER NOT NULL, rover_id INTEGER, step INTEGER NOT NULL DEFAULT 0, FOREIGN KEY (command_center_id) REFERENCES command_centers (id), FOREIGN KEY (rover_id) REFERENCES rovers (id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRover(String name, int resourcesExtracted) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO rovers (name, resources_extracted) VALUES (?, ?)")) {
            stmt.setString(1, name);
            stmt.setInt(2, resourcesExtracted);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCommandCenter(String name, int resourcesDelivered, int resourcesStock) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO command_centers (name, resources_delivered, resources_stock) VALUES (?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setInt(2, resourcesDelivered);
            stmt.setInt(3, resourcesStock);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertConstruction(String name, int resourcesUsed, int commandCenterId, int roverId, int step) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO constructions (name, resources_used, command_center_id, rover_id, step) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setInt(2, resourcesUsed);
            stmt.setInt(3, commandCenterId);
            stmt.setInt(4, roverId);
            stmt.setInt(5, step);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}