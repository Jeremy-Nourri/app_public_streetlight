package com.example.server_streetlight.service;

import com.example.server_streetlight.dto.managementRule.ManagementRuleRequestDTO;
import com.example.server_streetlight.dto.managementRule.ManagementRuleResponseDTO;

import java.util.List;

public interface ManagementRuleService {

    List<ManagementRuleResponseDTO> getAllManagementRules();

    ManagementRuleResponseDTO getManagementRuleById(Long id);

    ManagementRuleResponseDTO createManagementRule(ManagementRuleRequestDTO managementRuleRequestDTO);

    ManagementRuleResponseDTO updateManagementRule(Long id, ManagementRuleRequestDTO managementRuleRequestDTO);

    boolean deleteManagementRule(Long id);

}
