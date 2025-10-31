package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;


    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("==========================================");
            System.out.println("Welcome to the Car Dealership application!" );
            System.out.println("Choose the action:");
            System.out.println("1 - Find vehicles within a price range\n" +
                    "2 - Find vehicles by make / model\n" +
                    "3 - Find vehicles by year range\n" +
                    "4 - Find vehicles by color\n" +
                    "5 - Find vehicles by mileage range\n" +
                    "6 - Find vehicles by type (car, truck, SUV, van)\n" +
                    "7 - List ALL vehicles\n" +
                    "8 - Add a vehicle\n" +
                    "9 - Remove a vehicle\n" +
                    "99 - Quit");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> processGetByPriceRequest(scanner);
                case "2" -> processGetByMakeModelRequest(scanner);
                case "3" -> processGetByYearRequest(scanner);
                case "4" -> processGetByColorRequest(scanner);
                case "5" -> processGetByMileageRequest(scanner);
                case "6" -> processGetByVehicleTypeRequest(scanner);
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest(scanner);
                case "9" -> processRemoveVehicleRequest(scanner);
                case "99" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest(Scanner scanner) {
        System.out.print("Enter the vin:");
        int vin;
        while(true){
            try {
                vin = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the year:");
        int year;
        while(true){
            try {
                year = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the make:");
        String make = scanner.nextLine();
        System.out.print("Enter the model:");
        String model = scanner.nextLine();
        System.out.print("Enter the vehicle type:");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter the color:");
        String color = scanner.nextLine();
        System.out.print("Enter the mileage:");
        int mileage;
        while(true){
            try {
                mileage = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the price:");
        double price;
        while(true){
            try {
                price = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }

        dealership.addVehicle(new Vehicle(vin,year,make,model,vehicleType,color,mileage,price));
    }

    private void processRemoveVehicleRequest(Scanner scanner) {
        System.out.print("Enter the vin:");
        int vin;
        while(true){
            try {
                vin = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the year:");
        int year;
        while(true){
            try {
                year = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the make:");
        String make = scanner.nextLine();
        System.out.print("Enter the model:");
        String model = scanner.nextLine();
        System.out.print("Enter the vehicle type:");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter the color:");
        String color = scanner.nextLine();
        System.out.print("Enter the mileage:");
        int mileage;
        while(true){
            try {
                mileage = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the price:");
        double price;
        while(true){
            try {
                price = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }

        dealership.removeVehicle(new Vehicle(vin,year,make,model,vehicleType,color,mileage,price));
    }

    private  void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.println("Enter the vehicle type:");
        String vehicleType = scanner.nextLine();
        System.out.println(dealership.getVehiclesByType(vehicleType));
    }

    private void processGetByMileageRequest(Scanner scanner) {
        System.out.print("Enter the minimum mileage:");
        int min;
        while(true){
            try {
                min = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the maximum mileage:");
        int max;
        while(true){
            try {
                max = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        System.out.println(dealership.getVehiclesByMileage(min,max));
    }

    private  void processGetByColorRequest(Scanner scanner) {
        System.out.print("Enter the color:");
        String color = scanner.nextLine();
        System.out.println(dealership.getVehiclesByColor(color));
    }

    private void processGetByYearRequest(Scanner scanner) {
        System.out.print("Enter the minimum year:");
        int min;
        while(true){
            try {
                min = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the maximum year:");
        int max;
        while(true){
            try {
                max = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.println(dealership.getVehiclesByYear(min, max));
    }
    private void processGetByMakeModelRequest(Scanner scanner) {
        System.out.print("Enter the make:");
        String make = scanner.nextLine();
        System.out.println("Enter the model:");
        String model = scanner.nextLine();
        System.out.println(dealership.getVehiclesByMakeModel(make,model));
    }
    private void processGetByPriceRequest(Scanner scanner) {
        System.out.print("Enter the minimum price:");
        double min;
        while(true){
            try {
                min = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter the maximum price:");
        double max;
        while(true){
            try {
                max = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
        System.out.println(dealership.getVehiclesByPrice(min,max));

    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }



}