package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.RegionRequest;
import org.example.dto.RegionResponse;
import org.example.entity.RegionEntity;
import org.example.enums.Language;
import org.example.repository.RegionRepository;

import java.util.ArrayList;
import java.util.List;

public class RegionService {
    private final RegionRepository repository = new RegionRepository();

    public String createRegion(RegionRequest regionRequest) {
        RegionEntity regionEntity = new RegionEntity(
                regionRequest.getNameUz(),
                regionRequest.getNameEn(),
                regionRequest.getNameRu());
        repository.save(List.of(regionEntity));
        return "Success";
    }

    public List<RegionResponse> showRegion(Language language) {
        List<RegionEntity> entities = repository.readData();
        List<RegionResponse> dtos = new ArrayList<>();
        for (RegionEntity entity : entities) {
            String lan = switch (language) {
                case ru -> entity.getNameRu();
                case en -> entity.getNameEng();
                default -> entity.getNameUz();
            };
            RegionResponse response = new RegionResponse(
                    entity.getId(),
                    lan
            );
            dtos.add(response);
        }
        return dtos;
    }
}
