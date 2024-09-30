package com.example.server_streetlight.dto.managementRule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagementRuleRequestDTO {

    private String ruleName;

    private String condition;

    private String action;

    private HashSet<Long> streetlightIds;

}
