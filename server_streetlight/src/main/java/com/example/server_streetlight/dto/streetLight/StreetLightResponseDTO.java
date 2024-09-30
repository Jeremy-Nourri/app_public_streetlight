package com.example.server_streetlight.dto.streetLight;

import com.example.server_streetlight.entity.ManagementRule;
import com.example.server_streetlight.entity.Schedule;
import com.example.server_streetlight.entity.Sensor;
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
public class StreetLightResponseDTO {

    private Long id;

    private String location;

    private Boolean isActive;

    private double brightness;

    private double power;

    private List<Schedule> schedules;

    private List<Sensor> sensors;

    private Set<ManagementRule> managementRules = new HashSet<>();
}
