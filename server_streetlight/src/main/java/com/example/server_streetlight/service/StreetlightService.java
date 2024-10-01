package com.example.server_streetlight.service;

import com.example.server_streetlight.dto.streetLight.StreetLightResponseDTO;
import com.example.server_streetlight.dto.streetLight.StreetlightRequestDTO;
<<<<<<< Updated upstream

import java.util.List;
=======

import java.util.List;

public interface StreetlightService {

    List<StreetLightResponseDTO> getAllStreetlights();

    StreetLightResponseDTO getStreetlightById(Long id);

    StreetLightResponseDTO createStreetlight(StreetlightRequestDTO streetlightRequestDTO);

    StreetLightResponseDTO updateStreetlight(Long id, StreetlightRequestDTO streetlightRequestDTO);

    boolean deleteStreetlight(Long id);

    List<StreetLightResponseDTO> getStreetlightsByManagementRuleId(Long managementRuleId);



>>>>>>> Stashed changes

public interface StreetLightService {
    List<StreetLightResponseDTO> getAllStreetlights();
    StreetLightResponseDTO getStreetlightById(Long id);
    StreetLightResponseDTO createStreetlight(StreetlightRequestDTO streetlightRequestDTO);
    StreetLightResponseDTO updateStreetlight(Long id, StreetlightRequestDTO streetlightRequestDTO);
    boolean deleteStreetlight(Long id);
    boolean activeStreetlight(Long id);

}
