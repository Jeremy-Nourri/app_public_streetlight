package com.example.server_streetlight.service;

import com.example.server_streetlight.dto.sensor.SensorRequestDTO;
import com.example.server_streetlight.dto.sensor.SensorResponseDTO;

import java.util.List;

public interface SensorService {
    List<SensorResponseDTO> getAllSensors();

    SensorResponseDTO getSensorById(Long id);

    SensorResponseDTO createSensor(SensorRequestDTO sensorRequestDTO);

    SensorResponseDTO updateSensor(Long id, SensorRequestDTO sensorRequestDTO);

    boolean deleteSensor(Long id);

    List<SensorResponseDTO> getSensorsByStreetlightId(Long streetlightId);

    List<SensorResponseDTO> getSensorsByStreetlightIdAndType(Long streetlightId, String type);


}
