package com.example.server_streetlight.controller;

import com.example.server_streetlight.dto.managementRule.ManagementRuleRequestDTO;
import com.example.server_streetlight.dto.managementRule.ManagementRuleResponseDTO;
import com.example.server_streetlight.service.ManagementRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/management")
public class ManagementRuleController {

    @Autowired
    private ManagementRuleService managementRuleService;

    @GetMapping
    public ResponseEntity<List<ManagementRuleResponseDTO>> getManagementRules() {
        return ResponseEntity.ok(managementRuleService.getAllManagementRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagementRuleResponseDTO> getManagementRuleById(@PathVariable Long id) {
        Optional<ManagementRuleResponseDTO> managementRule = Optional.ofNullable(managementRuleService.getManagementRuleById(id));
        return managementRule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity <ManagementRuleResponseDTO> createManagementRule(@RequestBody ManagementRuleRequestDTO managementRuleRequest) {
        ManagementRuleResponseDTO managementRule = managementRuleService.createManagementRule(managementRuleRequest);
        return ResponseEntity.ok(managementRule);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ManagementRuleResponseDTO> updateManagementRule(@PathVariable Long id, @RequestBody ManagementRuleRequestDTO managementRuleRequest) {
        Optional<ManagementRuleResponseDTO> managementRule = Optional.ofNullable(managementRuleService.updateManagementRule(id, managementRuleRequest));
        return managementRule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ManagementRuleResponseDTO> deleteManagementRule(@PathVariable Long id) {
        if (managementRuleService.deleteManagementRule(id)) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
