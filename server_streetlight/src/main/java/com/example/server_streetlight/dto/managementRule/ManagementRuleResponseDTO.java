package com.example.server_streetlight.dto.managementRule;

import com.example.server_streetlight.entity.Streetlight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagementRuleResponseDTO {

    private Long id;

    private String ruleName;

    private String condition;

    private String action;

    private HashSet<Streetlight> streetlights;
}
