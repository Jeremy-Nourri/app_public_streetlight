package com.example.server_streetlight.service.impl;

import com.example.server_streetlight.dto.schedule.ScheduleRequestDTO;
import com.example.server_streetlight.dto.streetLight.StreetLightResponseDTO;
import com.example.server_streetlight.dto.streetLight.StreetlightRequestDTO;
import com.example.server_streetlight.entity.ManagementRule;
import com.example.server_streetlight.entity.Schedule;
import com.example.server_streetlight.entity.Sensor;
import com.example.server_streetlight.entity.Streetlight;
import com.example.server_streetlight.repository.StreetlightRepository;
import com.example.server_streetlight.service.StreetLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreetLightServiceImpl implements StreetLightService {

    @Autowired
    private final StreetlightRepository streetlightRepository;

    public StreetLightServiceImpl(StreetlightRepository streetlightRepository) {
        this.streetlightRepository = streetlightRepository;
    }

    @Override
    public List<StreetLightResponseDTO> getAllStreetlights() {
        List<Streetlight> streetlights = (List<Streetlight>) streetlightRepository.findAll();
        return streetlights.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StreetLightResponseDTO getStreetlightById(Long id) {
        return streetlightRepository.findById(id).map(this::convertToDTO).orElseThrow(
                () -> new RuntimeException("Streetlight with id " + id + " not found")
        );
    }

    @Override
    public StreetLightResponseDTO createStreetlight(StreetlightRequestDTO streetlightRequestDTO) {
        Streetlight streetlight = new Streetlight();
        streetlight.setLocation(streetlightRequestDTO.getLocation());
        streetlight.setBrightness(streetlightRequestDTO.getBrightness());
        streetlight.setPower(streetlightRequestDTO.getPower());
        List<Schedule> schedules = streetlightRequestDTO.getSchedulesIds().stream()
                .map(scheduleId -> {
                    Schedule schedule = new Schedule();
                    schedule.setId(scheduleId);
                    return schedule;
                }).collect(Collectors.toList());
        streetlight.setSchedules(schedules);
        List<Sensor> sensors = streetlightRequestDTO.getSensorsIds().stream()
                .map(sensorId -> {
                    Sensor sensor = new Sensor();
                    sensor.setId(sensorId);
                    return sensor;
                }).collect(Collectors.toList());
        streetlight.setSensors(sensors);
        HashSet<ManagementRule> managementRules = streetlightRequestDTO.getManagementRulesIds().stream()
                .map(managementRuleId -> {
                    ManagementRule managementRule = new ManagementRule();
                    managementRule.setId(managementRuleId);
                    return managementRule;
                }).collect(Collectors.toCollection(HashSet::new));
        streetlight.setManagementRules(managementRules);
        return convertToDTO(streetlightRepository.save(streetlight));

    }

    @Override
    public StreetLightResponseDTO updateStreetlight(Long id, StreetlightRequestDTO streetlightRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteStreetlight(Long id) {
        return false;
    }

    @Override
    public boolean activeStreetlight(Long id) {
        return false;
    }

    private StreetLightResponseDTO convertToDTO(Streetlight streetlight) {
        return StreetLightResponseDTO.builder()
                .id(streetlight.getId())
                .location(streetlight.getLocation())
                .brightness(streetlight.getBrightness())
                .power(streetlight.getPower())
                .schedules(streetlight.getSchedules())
                .sensors(streetlight.getSensors())
                .managementRules(streetlight.getManagementRules())
                .build();
    }
}