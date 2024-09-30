package com.example.server_streetlight.repository;

import com.example.server_streetlight.entity.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
