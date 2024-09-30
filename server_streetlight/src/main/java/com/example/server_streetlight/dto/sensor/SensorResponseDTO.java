package com.example.server_streetlight.dto.sensor;

import com.example.server_streetlight.entity.SensorType;
import com.example.server_streetlight.entity.Streetlight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorResponseDTO {

    private Long id;

    private SensorType type;

    private boolean isActive;

    private String sensorValue;

    private Streetlight streetlight;

    private String sensorLocation;
}
