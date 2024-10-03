package com.example.server_streetlight.controller;

import com.example.server_streetlight.dto.sensor.SensorRequestDTO;
import com.example.server_streetlight.dto.sensor.SensorResponseDTO;
import com.example.server_streetlight.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<SensorResponseDTO>> getAllSensors() {
        return ResponseEntity.ok(sensorService.getAllSensors());
    }

    @PostMapping("/createsensor")
    public ResponseEntity<SensorResponseDTO> createSensor(@RequestBody SensorRequestDTO sensorRequestDTO) {
        SensorResponseDTO createdSensor = sensorService.createSensor(sensorRequestDTO);
        return ResponseEntity.ok(createdSensor);
    }

    @PutMapping("/updatesensor/{id}")
    public ResponseEntity<SensorResponseDTO> updateSensor(@PathVariable Long id, @RequestBody SensorRequestDTO sensorRequestDTO) {
        Optional<SensorResponseDTO> updatedSensor = Optional.ofNullable(sensorService.updateSensor(id, sensorRequestDTO));
        return updatedSensor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletesensor/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        if (sensorService.deleteSensor(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> getSensorById(@PathVariable Long id) {
        Optional<SensorResponseDTO> sensor = Optional.ofNullable(sensorService.getSensorById(id));
        return sensor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
