package com.example.server_streetlight.dto.schedule;

import com.example.server_streetlight.entity.Day;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequestDTO {

    private LocalTime startTime;

    private LocalTime endTime;

    private Day day;

    private Long streetlightId;

}
