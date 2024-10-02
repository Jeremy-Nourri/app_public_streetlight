package com.example.server_streetlight.utils.observerTime;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(int hour);
}
