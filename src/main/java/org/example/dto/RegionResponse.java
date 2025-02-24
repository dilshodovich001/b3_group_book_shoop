package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.UUID;
@AllArgsConstructor
@ToString
public class RegionResponse {
    private UUID id;
    private String name;
}
