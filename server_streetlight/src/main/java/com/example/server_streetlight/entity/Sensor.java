package com.example.server_streetlight.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SensorType type;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String sensorValue;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "streetlight_id", nullable = false)
=======
>>>>>>> 9f9791130151d8a27e5ddfb125af09b80ccf74ee
    private Streetlight streetlight;

    @Column(nullable = false)
    private String sensorLocation;

}
