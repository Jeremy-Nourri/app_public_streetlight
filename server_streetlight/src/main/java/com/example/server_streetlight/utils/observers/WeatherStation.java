package com.example.server_streetlight.utils.observers;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private List<Observer> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        Weather weatherUpdate = Weather.builder().timeOfDay(TimeOfDay.NIGHTTIME).build();
        observers.forEach(observer -> observer.update(weatherUpdate));
    }
}
