package com.mt;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDataManager {
    private BasicDataSource basicDataSource;

    public VehicleDataManager(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public List<Vehicles> getByType(String typeToSearchBY) {

        List<Vehicles> vehicleFound = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE vehicle_type LIKE ?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, "%" + typeToSearchBY + "%");

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    String vin = resultSet.getString("vin");
                    Boolean sold = resultSet.getBoolean("sold");
                    String color = resultSet.getString("color");
                    String vehicle_type = resultSet.getString("vehicle_type");

                    Vehicles vehicles = new Vehicles(vin, sold, color, vehicle_type);

                    vehicleFound.add(vehicles);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleFound;
    }

    public List<Vehicles> getByColor(String colorToSearchBY) {

        List<Vehicles> vehicleFound = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE color LIKE ?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, "%" + colorToSearchBY + "%");

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    String vin = resultSet.getString("vin");
                    Boolean sold = resultSet.getBoolean("sold");
                    String color = resultSet.getString("color");
                    String vehicle_type = resultSet.getString("vehicle_type");

                    Vehicles vehicles = new Vehicles(vin, sold, color, vehicle_type);

                    vehicleFound.add(vehicles);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleFound;
    }



}