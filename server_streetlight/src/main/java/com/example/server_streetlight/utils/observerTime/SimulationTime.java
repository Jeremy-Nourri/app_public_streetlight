package com.example.server_streetlight.utils.observerTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class SimulationTime implements StreetlightSubject, Runnable {

    @Getter
    private int hour;
    private List<StreetlightObserver> observers;

    public SimulationTime(int hour) {
        this.hour = hour;
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(StreetlightObserver observer) {
      observers.add(observer);
    }

    @Override
    public void removeObserver(StreetlightObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int hour) {
        observers.forEach(observer -> observer.update(hour));
    }

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(1000 * 10);
                hour = (hour + 1) % 24;
                notifyObservers(hour);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
