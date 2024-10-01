package com.example.server_streetlight.utils.observers;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Weather {
    private TimeOfDay timeOfDay;
    private WeatherCondition weatherCondition;
}
