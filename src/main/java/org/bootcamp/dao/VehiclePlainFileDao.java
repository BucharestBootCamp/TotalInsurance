package org.bootcamp.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
@Profile("plaindb")
public class VehiclePlainFileDao implements VehicleDao {


    private static int VEHICLE_TYPE_NAME = 1;
    private static int VEHICLE_AGE = 3;
    private static int VEHICLE_NUMBER_OF_MILES = 4;
    private static int VEHICLE_IS_DIESEL = 5;
    private static int VEHICLE_FORMULA = 2;
    private static int VEHICLE_ID = 0;

    @Value("${filepath}")
    private String filePath;

    @Override
    public List<VehicleInfo> getAllVehicles() {
        List<VehicleInfo> infoList = new ArrayList<>();

        File vehiclesDatabase = new File(this.filePath);

        try {
            FileInputStream fileInputStream = new FileInputStream(vehiclesDatabase);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");

                VehicleInfo vehicleInfo = new VehicleInfo(tokens[VEHICLE_ID], tokens[VEHICLE_TYPE_NAME], tokens[VEHICLE_FORMULA],
                        Integer.parseInt(tokens[VEHICLE_AGE]), Long.parseLong(tokens[VEHICLE_NUMBER_OF_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));

                infoList.add(vehicleInfo);
            }

            scanner.close();
            fileInputStream.close();

        } catch (FileNotFoundException problemOpeningFile) {
            return Collections.emptyList();
        } catch (IOException problemClosingString) {
            return Collections.emptyList();
        }

        return infoList;
    }
}
