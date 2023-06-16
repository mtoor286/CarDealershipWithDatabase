package com.mt;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();

        String username = args[0];
        String password = args[1];

        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership?reconnect=true");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        DealershipDataManager dealershipDataManager = new DealershipDataManager(basicDataSource);
        VehicleDataManager vehicleDataManager = new VehicleDataManager(basicDataSource);

        //  Get list of all dealerships:
//        List<Dealership> dealerships = dealershipDataManager.getAllDealerships();
//        System.out.println(dealerships);

        //  Get list of all dealerships by name:
//        List<Dealership> dealerships = dealershipDataManager.getDealershipBYName("RoCar");
//        System.out.println(dealerships);

        //  Get list of vehicles by type:
        List<Vehicles> vehicles = vehicleDataManager.getByType("Coupe");
        System.out.println(vehicles);

        //  Get list of vehicles by color:
//        List<Vehicles> vehicles = vehicleDataManager.getByColor("Red");
//        System.out.println(vehicles);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //  Add dealership:
//        Dealership dealership = new Dealership(8,"Auto Cars", "162 James St", "980-457-8269");
//        dealershipDataManager.add(dealership);

        //  Delete dealership:
//        dealershipDataManager.delete(0);

        //  Update dealership:
//        Dealership dealership = new Dealership(8, "Auto Cars", "162 James St", "980-457-8269");
//        dealershipDataManager.update(dealership);

    }
}