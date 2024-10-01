package com.example.server_streetlight.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class ManagementRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    @Column(nullable = false)
    private String condition;

    @Column(nullable = false)
    private String action;

   @ManyToMany
   @JoinTable(
           name = "management_rule_streetlight",
           joinColumns = @JoinColumn(name = "management_rule_id"),
           inverseJoinColumns = @JoinColumn(name = "streetlight_id")
   )
   private HashSet<Streetlight> streetlights;


}
