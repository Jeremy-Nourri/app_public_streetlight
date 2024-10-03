package com.example.server_streetlight.utils.observerTime;

import java.util.ArrayList;
import java.util.List;

public class SimulatedClock implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(int hour) {
        for (Observer observer : observers) {
            observer.update(hour);
        }
    }
}
