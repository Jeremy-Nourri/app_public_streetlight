package com.example.server_streetlight.dto.streetLight;

import com.example.server_streetlight.dto.managementRule.ManagementRuleResponseDTO;
import com.example.server_streetlight.dto.schedule.ScheduleResponseDTO;
import com.example.server_streetlight.dto.sensor.SensorResponseDTO;
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

    private List<ScheduleResponseDTO> schedules;

    private List<SensorResponseDTO> sensors;

    private Set<ManagementRuleResponseDTO> managementRules = new HashSet<>();
}
