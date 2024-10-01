package com.example.server_streetlight.service.impl;

import com.example.server_streetlight.dto.sensor.SensorRequestDTO;
import com.example.server_streetlight.dto.sensor.SensorResponseDTO;
import com.example.server_streetlight.entity.Sensor;
import com.example.server_streetlight.repository.SensorRepository;
import com.example.server_streetlight.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<SensorResponseDTO> getAllSensors() {
        List<Sensor> sensors = (List<Sensor>) sensorRepository.findAll();
        return sensors.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public SensorResponseDTO getSensorById(Long id) {
        return sensorRepository.findById(id).map(this::convertToDTO).orElseThrow(
                () -> new RuntimeException("Sensor with id " + id + " not found")
        );
    }

    @Override
    public SensorResponseDTO createSensor(SensorRequestDTO sensorRequestDTO) {
        return null;
    }

    @Override
    public SensorResponseDTO updateSensor(Long id, SensorRequestDTO sensorRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteSensor(Long id) {
        return false;
    }

    @Override
    public List<SensorResponseDTO> getSensorsByStreetlightId(Long streetlightId) {
        return List.of();
    }

    @Override
    public List<SensorResponseDTO> getSensorsByStreetlightIdAndType(Long streetlightId, String type) {
        return List.of();
    }


    public SensorResponseDTO convertToDTO(Sensor sensor) {
        SensorResponseDTO sensorResponseDTO = new SensorResponseDTO();
        sensorResponseDTO.setId(sensor.getId());
        sensorResponseDTO.setType(sensor.getType());
        sensorResponseDTO.setSensorLocation(sensor.getSensorLocation());
        sensorResponseDTO.setSensorValue(sensor.getSensorValue());
        sensorResponseDTO.setActive(sensor.isActive());
        return sensorResponseDTO;

    }
}
