package com.busreservation.persistence;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonFileManager {
    private static final String FILE_PATH = "data/reservations.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    // SAVE - Called after every book / cancel
    public static void saveData(ReservationData data) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
            System.out.println("Data saved to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // LOAD - Called when program starts
    public static ReservationData loadData() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("No saved file found. Starting fresh.");
                return new ReservationData();
            }
            ReservationData data = mapper.readValue(file, ReservationData.class);
            System.out.println("Data loaded from " + FILE_PATH);
            return data;
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ReservationData();
        }
    }
}