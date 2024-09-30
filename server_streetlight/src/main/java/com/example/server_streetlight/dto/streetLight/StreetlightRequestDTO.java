package com.example.server_streetlight.dto.streetLight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StreetlightRequestDTO {

    private String location;

    private Boolean isActive;

    private double brightness;

    private double power;

    private List<Long> schedulesIds;

    private List<Long> sensorsIds;

    private Set<Long> managementRulesIds = new HashSet<>();

}

