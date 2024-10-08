package com.example.server_streetlight.repository;

import com.example.server_streetlight.entity.Streetlight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetlightRepository extends CrudRepository<Streetlight, Long> {
    List<Streetlight> findByManagementRulesId(Long managementRuleId);
}
