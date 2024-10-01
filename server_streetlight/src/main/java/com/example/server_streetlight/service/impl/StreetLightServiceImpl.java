package com.example.server_streetlight.service.impl;

import com.example.server_streetlight.dto.managementRule.ManagementRuleResponseDTO;
import com.example.server_streetlight.dto.schedule.ScheduleResponseDTO;
import com.example.server_streetlight.dto.sensor.SensorResponseDTO;
import com.example.server_streetlight.dto.streetLight.StreetLightResponseDTO;
import com.example.server_streetlight.dto.streetLight.StreetlightRequestDTO;
import com.example.server_streetlight.entity.Streetlight;
import com.example.server_streetlight.exception.StreetlightNotFoundException;
import com.example.server_streetlight.repository.StreetlightRepository;
import com.example.server_streetlight.service.StreetLightService;
import com.example.server_streetlight.utils.observers.Observer;
import com.example.server_streetlight.utils.observers.TimeOfDay;
import com.example.server_streetlight.utils.observers.Weather;
import com.example.server_streetlight.utils.observers.WeatherCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreetLightServiceImpl implements StreetLightService, Observer {


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
                () -> new StreetlightNotFoundException("Streetlight with id " + id + " not found")
        );
    }

    @Override
    public StreetLightResponseDTO createStreetlight(StreetlightRequestDTO streetlightRequestDTO) {
        Streetlight streetlight = new Streetlight();
        streetlight.setLocation(streetlightRequestDTO.getLocation());
        streetlight.setBrightness(streetlightRequestDTO.getBrightness());
        streetlight.setPower(streetlightRequestDTO.getPower());
        return convertToDTO(streetlightRepository.save(streetlight));

    }

    @Override
    public StreetLightResponseDTO updateStreetlight(Long id, StreetlightRequestDTO streetlightRequestDTO) {
        return streetlightRepository.findById(id).map(streetlight -> {
            streetlight.setLocation(streetlightRequestDTO.getLocation());
            streetlight.setBrightness(streetlightRequestDTO.getBrightness());
            streetlight.setPower(streetlightRequestDTO.getPower());
            return convertToDTO(streetlightRepository.save(streetlight));
        }).orElseThrow(() -> new StreetlightNotFoundException("Streetlight with id " + id + " not found"));
    }

    @Override
    public boolean deleteStreetlight(Long id) {
        Streetlight streetlight = streetlightRepository.findById(id).orElseThrow(
                () -> new StreetlightNotFoundException("Streetlight with id " + id + " not found")
        );
        streetlightRepository.delete(streetlight);
        Streetlight deletedStreetlight = streetlightRepository.findById(id).orElse(null);
        return deletedStreetlight == null;
    }

    @Override
    public boolean activeStreetlight(Long id) {
        return false;
    }

    @Override
    public List<StreetLightResponseDTO> getStreetlightsByManagementRuleId(Long managementRuleId) {
        return List.of();
    }

    public StreetLightResponseDTO convertToDtoWithFullAttributes(Streetlight streetlight) {
        return StreetLightResponseDTO.builder()
                .id(streetlight.getId())
                .location(streetlight.getLocation())
                .brightness(streetlight.getBrightness())
                .power(streetlight.getPower())
                .schedules(streetlight.getSchedules().stream().map(schedule -> ScheduleResponseDTO.builder()
                        .id(schedule.getId())
                        .startTime(schedule.getStartTime())
                        .endTime(schedule.getEndTime())
                        .streetlight(StreetLightResponseDTO.builder()
                                .id(schedule.getStreetlight().getId())
                                .location(schedule.getStreetlight().getLocation())
                                .build())
                        .build()).collect(Collectors.toList()))
                .sensors(streetlight.getSensors().stream().map(sensor -> SensorResponseDTO.builder()
                        .id(sensor.getId())
                        .type(sensor.getType())
                        .isActive(sensor.isActive())
                        .sensorValue(sensor.getSensorValue())
                        .streetlight(StreetLightResponseDTO.builder()
                                .id(sensor.getStreetlight().getId())
                                .location(sensor.getStreetlight().getLocation())
                                .build())
                        .sensorLocation(sensor.getSensorLocation())
                        .build()).collect(Collectors.toList()))
                .managementRules(streetlight.getManagementRules().stream().map(managementRule -> ManagementRuleResponseDTO.builder()
                        .id(managementRule.getId())
                        .ruleName(managementRule.getRuleName())
                        .condition(managementRule.getCondition())
                        .action(managementRule.getAction())
                        .build()).collect(Collectors.toSet()))
                .isActive(streetlight.isActive())

                .build();

    }

    public StreetLightResponseDTO convertToDTO(Streetlight streetlight) {
        return StreetLightResponseDTO.builder()
                .id(streetlight.getId())
                .location(streetlight.getLocation())
                .brightness(streetlight.getBrightness())
                .power(streetlight.getPower())
                .build();
    }

    @Override
    public void update(Weather weather) {
        if (weather.getTimeOfDay() == TimeOfDay.NIGHTTIME ||
                weather.getTimeOfDay() == TimeOfDay.AURORA ||
                weather.getTimeOfDay() == TimeOfDay.DUSK) {

            if (weather.getWeatherCondition() == WeatherCondition.SNOW) {
                adjustStreetlightBrightness(3);
            }

            else if (weather.getWeatherCondition() == WeatherCondition.FOG ||
                    weather.getWeatherCondition() == WeatherCondition.RAIN) {
                adjustStreetlightBrightness(2);
            }

            else {
                adjustStreetlightBrightness(1);
            }
        }

        else if ((weather.getWeatherCondition() == WeatherCondition.FOG ||
                weather.getWeatherCondition() == WeatherCondition.RAIN||
                weather.getWeatherCondition() == WeatherCondition.SNOW) &&
                weather.getTimeOfDay() == TimeOfDay.DAYTIME) {
            adjustStreetlightBrightness(2);
        }

        else {
            adjustStreetlightBrightness(0);
        }
    }

    private void adjustStreetlightBrightness(int brightness) {
        List<Streetlight> streetlights = (List<Streetlight>) streetlightRepository.findAll();
        for (Streetlight streetlight : streetlights) {
            streetlight.setBrightness(brightness);
            streetlightRepository.save(streetlight);
        }
    }
}
