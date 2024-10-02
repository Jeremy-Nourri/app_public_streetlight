package com.example.server_streetlight.utils.observerTime;

public interface StreetlightSubject {
    void addObserver(StreetlightObserver observer);
    void removeObserver(StreetlightObserver observer);
    void notifyObservers(int hour);
}
