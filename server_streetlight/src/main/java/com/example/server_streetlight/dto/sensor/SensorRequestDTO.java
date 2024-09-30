package com.example.server_streetlight.dto.sensor;

import com.example.server_streetlight.entity.SensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorRequestDTO {

    private SensorType type;

    private boolean isActive;

    private String sensorValue;

    private Long streetlightId;

    private String sensorLocation;

}
