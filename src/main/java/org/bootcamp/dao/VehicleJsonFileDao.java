package org.bootcamp.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("jsondb")
public class VehicleJsonFileDao implements VehicleDao {
    @Value("${filepath}")
    private String filePath;

    @Override
    public List<VehicleInfo> getAllVehicles() {
        List<VehicleInfo> infos = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            infos = objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, VehicleInfo.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return infos;
    }
}
