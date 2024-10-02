package com.example.server_streetlight.utils.observerTime;

public class Streetlight implements StreetlightObserver {

    private boolean streetlightStatus;

    public Streetlight() {
        streetlightStatus = false;
    }

    @Override
    public void update(int hour) {
        if(hour >= 19 || hour < 7){
            streetlightStatus = true;
        }else {
            streetlightStatus = false;
        }
    }

    public void streetlightActive(int hour) {
        if(!streetlightStatus){
            System.out.println("Streetlight is still active" + String.format("%02d", hour));
            streetlightStatus = true;
        }
    }

    public void streetlightInactive(int hour) {
        if(streetlightStatus){
            System.out.println("Streetlight is still inactive" + String.format("%02d", hour));
        }
    }

}
