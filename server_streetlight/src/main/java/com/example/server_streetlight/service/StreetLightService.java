package com.example.server_streetlight.service;

import com.example.server_streetlight.dto.streetLight.StreetLightResponseDTO;
import com.example.server_streetlight.dto.streetLight.StreetlightRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StreetLightService {

    List<StreetLightResponseDTO> getAllStreetlights();

    StreetLightResponseDTO getStreetlightById(Long id);

    StreetLightResponseDTO createStreetlight(StreetlightRequestDTO streetlightRequestDTO);

    StreetLightResponseDTO updateStreetlight(Long id, StreetlightRequestDTO streetlightRequestDTO);

    boolean deleteStreetlight(Long id);

    boolean activeStreetlight(Long id);

    List<StreetLightResponseDTO> getStreetlightsByManagementRuleId(Long managementRuleId);
}
