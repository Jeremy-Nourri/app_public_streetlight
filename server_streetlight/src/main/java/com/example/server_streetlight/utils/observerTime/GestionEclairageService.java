package com.example.server_streetlight.utils.observerTime;

import com.example.server_streetlight.dto.streetLight.StreetLightResponseDTO;
import com.example.server_streetlight.entity.Streetlight;
import com.example.server_streetlight.repository.StreetlightRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GestionEclairageService implements Observer {

    private SimulatedClock simulatedClock;
    private Streetlight streetlight;

    private int hour = 0;

    @Autowired
    private StreetlightRepository streetlightRepository;

    @PostConstruct
    public void init() {
        simulatedClock = new SimulatedClock();

        streetlight = streetlightRepository.findById(1L).orElse(null);
        if (streetlight == null) {
            streetlight = new Streetlight();
            streetlight.setActive(false);
            streetlightRepository.save(streetlight);
        }

        simulatedClock.addObserver(this);

        System.out.println("GestionEclairageService: Lampadaire initialisé avec isActive = false.");
    }


    @Scheduled(fixedRate = 10000)
    public void updateClock() {
        System.out.println("updateClock appelé.");
        hour = (hour + 1) % 24;
        System.out.println("GestionEclairageService: Heure actuelle : " + hour + "h");
        notifyObservers();
    }

    @Override
    public void update(int hour) {
        if (hour >= 19 || hour < 7) {
            streetlight.setActive(true);
            System.out.println("Lampadaire allumé. Heure : " + hour + "h");
        } else {
            streetlight.setActive(false);
            System.out.println("Lampadaire éteint. Heure : " + hour + "h");
        }

        streetlightRepository.save(streetlight);
    }

    public void notifyObservers() {
        simulatedClock.notifyObservers(hour);
    }

    public Integer getHour() {
        return hour;
    }
}
