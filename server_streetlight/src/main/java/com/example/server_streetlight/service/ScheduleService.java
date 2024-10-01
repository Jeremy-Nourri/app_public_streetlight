package com.example.server_streetlight.service;

import com.example.server_streetlight.dto.schedule.ScheduleRequestDTO;
import com.example.server_streetlight.dto.schedule.ScheduleResponseDTO;

import java.util.List;

public interface ScheduleService {

    List<ScheduleResponseDTO> getAllSchedules();

    ScheduleResponseDTO getScheduleById(Long id);

    ScheduleResponseDTO createSchedule(ScheduleRequestDTO scheduleRequestDTO);

    ScheduleResponseDTO updateSchedule(Long id, ScheduleRequestDTO scheduleRequestDTO);

    boolean deleteSchedule(Long id);

}
