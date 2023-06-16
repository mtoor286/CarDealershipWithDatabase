package com.mt;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipDataManager {
    private BasicDataSource basicDataSource;

    public DealershipDataManager(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public List<Dealership> getAllDealerships() {

        List<Dealership> dealerships = new ArrayList<>();
        String query = "SELECT * FROM dealerships;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                int dealership_id = resultSet.getInt("dealership_id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");

                Dealership dealership = new Dealership(dealership_id, name, address, phone);

                dealerships.add(dealership);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dealerships;
    }
    public List<Dealership> getDealershipBYName(String nameToSearchBY) {

        List<Dealership> dealershipFound = new ArrayList<>();
        String query = "SELECT * FROM dealerships WHERE name LIKE ?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, "%" + nameToSearchBY + "%");

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int dealership_id = resultSet.getInt("dealership_id");
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");

                    Dealership dealership = new Dealership(dealership_id, name, address, phone);

                    dealershipFound.add(dealership);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dealershipFound;
    }

    public void add(Dealership dealership){

        String query = "INSERT INTO dealerships(dealership_id, name, address, phone) VALUES(?, ?, ?, ?);";

        try(
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1,  dealership.getDealership_id());
            preparedStatement.setString(2, dealership.getName());
            preparedStatement.setString(3, dealership.getAddress());
            preparedStatement.setString(4,  dealership.getPhone());


            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated %d\n", rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int dealership_id){

        String query = "DELETE FROM dealerships WHERE dealership_id=?;";

        try(
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, dealership_id);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Dealership dealership) {

        String query = "UPDATE dealership SET name=?, address=?, phone=? WHERE dealership_id=?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, dealership.getName());
            preparedStatement.setString(2, dealership.getAddress());
            preparedStatement.setString(3, dealership.getPhone());
            preparedStatement.setInt(4, dealership.getDealership_id());

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
