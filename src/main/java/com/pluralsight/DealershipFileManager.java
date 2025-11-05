package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership() {

        Dealership dealership = null;
        ArrayList<Vehicle> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("dealership.csv"))) {

            String line = br.readLine();

            String[] parts = line.split("\\|");
            String name = parts[0];
            String address = parts[1];
            String phone = parts[2];
            dealership = new Dealership(name, address, phone);
            while ((line = br.readLine()) != null) {
                String[] partsCar = line.split("\\|");
                int vin = Integer.parseInt(partsCar[0]);
                int year = Integer.parseInt((partsCar[1]));
                String make = partsCar[2];
                String model = partsCar[3];
                String vehicleType = partsCar[4];
                String color = partsCar[5];
                int odometer = Integer.parseInt(partsCar[6]);
                double price = Double.parseDouble(partsCar[7]);
                inventory.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));

            }
            dealership.setInventory(inventory);
            return dealership;
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dealership.csv")) ) {
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();
            ArrayList<Vehicle> inventory = dealership.getAllVehicles();

            for (Vehicle vehicle : inventory) {
                bw.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                bw.newLine();
            }
            System.out.println("Dealership saved.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}