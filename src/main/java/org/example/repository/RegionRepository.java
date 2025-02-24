package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.ProfileEntity;
import org.example.entity.RegionEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegionRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("region.json");


    public void save(List<RegionEntity> regionEntities) {
        try {
            List<RegionEntity> response = readData();
            response.addAll(regionEntities);
            objectMapper.writeValue(file, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RegionEntity> readData() {
        if (!file.exists() && file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            return objectMapper.readValue(file, new TypeReference<List<RegionEntity>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
