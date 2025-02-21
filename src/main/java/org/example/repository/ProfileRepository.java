package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.ProfileEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("profile.json");

    public void save(List<ProfileEntity> profileEntities) {
        try {
            List<ProfileEntity> response = readData();
            response.addAll(profileEntities);
            objectMapper.writeValue(file, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProfileEntity> readData() {
        if (!file.exists() && file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            return objectMapper.readValue(file, new TypeReference<List<ProfileEntity>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
