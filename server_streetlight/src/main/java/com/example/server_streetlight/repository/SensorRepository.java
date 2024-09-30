package com.example.server_streetlight.repository;

import com.example.server_streetlight.entity.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Long> {
}
