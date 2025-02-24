package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.RegionEntity;

@Getter
@Setter
@AllArgsConstructor
public class RegionRequest {
    private String nameUz;
    private String nameRu;
    private String nameEn;
}
