package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private static final String CONTRACTS_FILE = "contracts.csv";

    public void saveContract(Contract contract) {
        try {
            if (contract instanceof SalesContract) {
                writeSalesContract((SalesContract) contract);
            }
            else if (contract instanceof LeaseContract) {
                writeLeaseContract((LeaseContract) contract);
            }
        } catch (Exception e) {
            System.out.println("Error saving contract");
        }
    }

    private void writeSalesContract(SalesContract contract) {
        Vehicle vehicle = contract.getVehicleSold();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE,true));
            String line = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                    contract.getDate(),
                    contract.getName(),
                    contract.getEmail(),
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice(),
                    contract.getSalesTaxAmount(),
                    contract.getRecordingFee(),
                    contract.getProcessingFee(),
                    contract.getTotalPrice(),
                    contract.isFinancing() ? "Yes" : "No",
                    contract.getMonthlyPayment()
            );
            writer.write(line);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void writeLeaseContract(LeaseContract contract) {
        Vehicle vehicle = contract.getVehicleSold();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE,true));
            String line = String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f",
                    contract.getDate(),
                    contract.getName(),
                    contract.getEmail(),
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice(),
                    contract.getExpectedEndingValue(),
                    contract.getLeaseFee(),
                    contract.getTotalPrice(),
                    contract.getMonthlyPayment()
            );

            writer.write(line);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}