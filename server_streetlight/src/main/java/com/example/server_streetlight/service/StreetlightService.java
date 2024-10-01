package com.example.server_streetlight.service;

import com.example.server_streetlight.dto.streetLight.StreetLightResponseDTO;
import com.example.server_streetlight.dto.streetLight.StreetlightRequestDTO;
import java.util.List;

public interface StreetlightService {
    List<StreetLightResponseDTO> getAllStreetlights();
    StreetLightResponseDTO getStreetlightById(Long id);
    StreetLightResponseDTO createStreetlight(StreetlightRequestDTO streetlightRequestDTO);
    StreetLightResponseDTO updateStreetlight(Long id, StreetlightRequestDTO streetlightRequestDTO);
    boolean deleteStreetlight(Long id);
    boolean activeStreetlight(Long id);

}
