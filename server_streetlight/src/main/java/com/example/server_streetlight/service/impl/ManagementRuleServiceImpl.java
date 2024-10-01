package com.example.server_streetlight.service.impl;

import com.example.server_streetlight.dto.managementRule.ManagementRuleRequestDTO;
import com.example.server_streetlight.dto.managementRule.ManagementRuleResponseDTO;
import com.example.server_streetlight.entity.ManagementRule;
import com.example.server_streetlight.repository.ManagementRuleRepository;
import com.example.server_streetlight.service.ManagementRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagementRuleServiceImpl implements ManagementRuleService {

    @Autowired
    private final ManagementRuleRepository managementRuleRepository;

    @Autowired
    private final StreetLightServiceImpl streetLightServiceImpl;

    public ManagementRuleServiceImpl(ManagementRuleRepository managementRuleRepository, StreetLightServiceImpl streetLightServiceImpl) {
        this.managementRuleRepository = managementRuleRepository;
        this.streetLightServiceImpl = streetLightServiceImpl;
    }

    @Override
    public List<ManagementRuleResponseDTO> getAllManagementRules() {
        List<ManagementRule> managementRules = (List<ManagementRule>) managementRuleRepository.findAll();
        return managementRules.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ManagementRuleResponseDTO getManagementRuleById(Long id) {
        return managementRuleRepository.findById(id).map(this::convertToDTO).orElseThrow(
                () -> new RuntimeException("ManagementRule with id " + id + " not found")
        );
    }

    @Override
    public ManagementRuleResponseDTO createManagementRule(ManagementRuleRequestDTO managementRuleRequestDTO) {
        ManagementRule managementRule = new ManagementRule();
        managementRule.setRuleName(managementRuleRequestDTO.getRuleName());
        managementRule.setCondition(managementRuleRequestDTO.getCondition());
        managementRule.setAction(managementRuleRequestDTO.getAction());
        return convertToDTO(managementRuleRepository.save(managementRule));
    }

    @Override
    public ManagementRuleResponseDTO updateManagementRule(Long id, ManagementRuleRequestDTO managementRuleRequestDTO) {
        ManagementRule managementRule = managementRuleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ManagementRule with id " + id + " not found")
        );
        managementRule.setRuleName(managementRuleRequestDTO.getRuleName());
        managementRule.setCondition(managementRuleRequestDTO.getCondition());
        managementRule.setAction(managementRuleRequestDTO.getAction());
        return convertToDTO(managementRuleRepository.save(managementRule));
    }

    @Override
    public boolean deleteManagementRule(Long id) {
        ManagementRule managementRule = managementRuleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ManagementRule with id " + id + " not found")
        );
        managementRuleRepository.delete(managementRule);
        ManagementRule deletedManagementRule = managementRuleRepository.findById(id).orElse(null);
        return deletedManagementRule == null;
    }

    public ManagementRuleResponseDTO convertToDTO(ManagementRule managementRule) {
        ManagementRuleResponseDTO managementRuleResponseDTO = new ManagementRuleResponseDTO();
        managementRuleResponseDTO.setId(managementRule.getId());
        managementRuleResponseDTO.setRuleName(managementRule.getRuleName());
        managementRuleResponseDTO.setCondition(managementRule.getCondition());
        managementRuleResponseDTO.setAction(managementRule.getAction());
        return managementRuleResponseDTO;
    }
}
