package com.example.server_streetlight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Streetlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private double brightness;

    @Column(nullable = false)
    private double power;

    @OneToMany(mappedBy = "streetlight")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "streetlight")
    private List<Sensor> sensors;

    @ManyToMany(mappedBy = "streetlights")
    private Set<ManagementRule> managementRules = new HashSet<>();

}
