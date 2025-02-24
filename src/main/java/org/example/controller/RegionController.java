package org.example.controller;

import org.example.dto.RegionRequest;
import org.example.dto.RegionResponse;
import org.example.enums.Language;
import org.example.service.RegionService;

import java.util.List;

public class RegionController {
    private final RegionService regionService = new RegionService();
    public String createRegion(RegionRequest regionRequest) {
        return regionService.createRegion(regionRequest);
    }

    public List<RegionResponse> showRegion(Language language) {
        return regionService.showRegion(language);
    }
}
