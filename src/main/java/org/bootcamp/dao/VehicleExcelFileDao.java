package org.bootcamp.dao;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
@Profile("exceldb")
public class VehicleExcelFileDao implements VehicleDao {
    @Value("${filepath}")
    private String filePath;

    @Override
    public List<VehicleInfo> getAllVehicles() {
        List<VehicleInfo> infos = new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                List<Cell> cells = new ArrayList<>();

                for (int i = 0; i < 6; i++) {
                    Cell currentCell = cellIterator.next();
                    cells.add(currentCell);
                }

                VehicleInfo vehicleInfo = new VehicleInfo(cells.get(0).getStringCellValue(), cells.get(1).getStringCellValue(), cells.get(2).getStringCellValue(),
                        (int) cells.get(3).getNumericCellValue(), (long) cells.get(4).getNumericCellValue(), cells.get(5).getBooleanCellValue());

                infos.add(vehicleInfo);
            }
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        } catch (IOException e) {
            return Collections.emptyList();
        }

        return infos;
    }
}
