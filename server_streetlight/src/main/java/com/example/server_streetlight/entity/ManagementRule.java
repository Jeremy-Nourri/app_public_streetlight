package com.example.server_streetlight.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.util.HashSet;

=======
>>>>>>> 9f9791130151d8a27e5ddfb125af09b80ccf74ee
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

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

<<<<<<< HEAD
   @ManyToMany
   @JoinTable(
           name = "management_rule_streetlight",
           joinColumns = @JoinColumn(name = "management_rule_id"),
           inverseJoinColumns = @JoinColumn(name = "streetlight_id")
   )
   private HashSet<Streetlight> streetlights;

=======
    @ManyToOne
    private Streetlight streetlight;
>>>>>>> 9f9791130151d8a27e5ddfb125af09b80ccf74ee

}
