package com.example.server_streetlight.service.impl;

import com.example.server_streetlight.dto.schedule.ScheduleRequestDTO;
import com.example.server_streetlight.dto.schedule.ScheduleResponseDTO;
import com.example.server_streetlight.entity.Schedule;
import com.example.server_streetlight.repository.ScheduleRepository;
import com.example.server_streetlight.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleResponseDTO> getAllSchedules() {
        List<Schedule> schedules = (List<Schedule>) scheduleRepository.findAll();
        return schedules.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public ScheduleResponseDTO getScheduleById(Long id) {
        return scheduleRepository.findById(id).map(this::convertToDTO).orElseThrow(
                () -> new RuntimeException("Schedule with id " + id + " not found")
        );
    }

    @Override
    public ScheduleResponseDTO createSchedule(ScheduleRequestDTO scheduleRequestDTO) {
        Schedule schedule = new Schedule();
        schedule.setStartTime(scheduleRequestDTO.getStartTime());
        schedule.setEndTime(scheduleRequestDTO.getEndTime());
        return convertToDTO(scheduleRepository.save(schedule));
    }

    @Override
    public ScheduleResponseDTO updateSchedule(Long id, ScheduleRequestDTO scheduleRequestDTO) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Schedule with id " + id + " not found")
        );

        schedule.setStartTime(scheduleRequestDTO.getStartTime());
        schedule.setEndTime(scheduleRequestDTO.getEndTime());
        return convertToDTO(scheduleRepository.save(schedule));
    }

    @Override
    public boolean deleteSchedule(Long id) {
        ScheduleResponseDTO scheduleResponseDTO = scheduleRepository.findById(id).map(this::convertToDTO).orElseThrow(
                () -> new RuntimeException("Schedule with id " + id + " not found")
        );
        scheduleRepository.deleteById(id);
        ScheduleResponseDTO deletedSchedule = scheduleRepository.findById(id).map(this::convertToDTO).orElse(null);
        return deletedSchedule == null;
    }

    public ScheduleResponseDTO convertToDTO(Schedule schedule) {
        ScheduleResponseDTO scheduleResponseDTO = new ScheduleResponseDTO();
        scheduleResponseDTO.setId(schedule.getId());
        scheduleResponseDTO.setStartTime(schedule.getStartTime());
        scheduleResponseDTO.setEndTime(schedule.getEndTime());
        return scheduleResponseDTO;
    }
}
