package com.example.server_streetlight.controller;

import com.example.server_streetlight.dto.streetLight.StreetLightResponseDTO;
import com.example.server_streetlight.service.StreetLightService;
import com.example.server_streetlight.utils.observerTime.GestionEclairageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/api/streetlights")
public class StreetlightStatusController {

    @Autowired
    private final StreetLightService streetLightService;
    @Autowired
    private final GestionEclairageService gestionEclairageService;

    public StreetlightStatusController(StreetLightService streetLightService, GestionEclairageService gestionEclairageService) {
        this.streetLightService = streetLightService;
        this.gestionEclairageService = gestionEclairageService;
    }


    @GetMapping("/{id}/status")
    public ResponseEntity<Boolean> getStreetlightStatus(@PathVariable Long id) {
        StreetLightResponseDTO streetlight = streetLightService.getStreetlightById(id);
        return ResponseEntity.ok(streetlight.getIsActive());
    }

    @GetMapping("/time")
    public ResponseEntity<Integer> getTime() {
        return ResponseEntity.ok(gestionEclairageService.getHour());
    }
}

