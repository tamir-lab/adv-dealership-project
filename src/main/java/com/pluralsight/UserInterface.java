package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    "10 - Sell or lease a vehicle\n" +
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
                case "10" -> processSellOrLease(scanner);
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

    private void processSellOrLease(Scanner scanner){
        displayVehicles(dealership.getAllVehicles());

        Vehicle vehicle = null;
        int vin = 0;

        do {
            try {
                System.out.print("Enter the vin of the vehicle you want to sell or lease: ");
                vin = scanner.nextInt();
                scanner.nextLine();

                ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
                for (Vehicle vehicle1 : vehicles) {
                    if (vehicle.getVin() == vin){
                        vehicle = vehicle1;
                    }
                }

                if (vehicle == null) {
                    System.out.println("Vehicle not found. Please try again.");
                    vin = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid VIN.");
                scanner.nextLine();
                vin = 0;
            }
        } while (vehicle == null);

        System.out.print("Enter contract date (YYYYMMDD): ");
        String date = scanner.nextLine().trim();

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine().trim();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine().trim();

        System.out.print("Is this Sale or Lease? ");
        String type = scanner.nextLine().trim();

        Contract contract;

        if (type.equalsIgnoreCase("Lease")) {
            int currentYear = LocalDate.now().getYear();
            int vehicleAge = currentYear - vehicle.getYear();

            if (vehicleAge > 3) {
                System.out.println("ERROR: Cannot lease a vehicle over 3 years old.");
                return;
            }

            contract = new LeaseContract(date, customerName, customerEmail, vehicle);


        } else if (type.equalsIgnoreCase("Sale")) {
            double salesTax = vehicle.getPrice() * 0.05;
            double recordingFee = 100.00;
            double processingFee = (vehicle.getPrice() < 10000) ? 295.00 : 495.00;

            System.out.println("Would you like to finance? (Y/N): ");
            String financeChoice = scanner.nextLine().trim().toUpperCase();
            boolean isFinance = financeChoice.equals("Y");

            contract = new SalesContract(date, customerName, customerEmail, vehicle,
                    salesTax, recordingFee, processingFee, isFinance);
            System.out.println("Sales contract created!");

        } else {
            System.out.println("Invalid option. Returning to menu.");
            return;
        }

        ContractFileManager contractManager = new ContractFileManager();
        contractManager.saveContract(contract);

        dealership.removeVehicle(vehicle);

        DealershipFileManager df = new DealershipFileManager();
        df.saveDealership(dealership);
        System.out.println("=".repeat(80));
        System.out.println("\nContract saved successfully!");
        System.out.println("=".repeat(80));
    }



}