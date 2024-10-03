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
    private Streetlight streetlight; // À initialiser correctement

    private int hour = 0;

    @Autowired
    private StreetlightRepository streetlightRepository;

    @PostConstruct
    public void init() {
        simulatedClock = new SimulatedClock();



        // Récupérer un lampadaire existant ou en créer un nouveau si nécessaire
        streetlight = streetlightRepository.findById(1L).orElse(null);
        if (streetlight == null) {
            streetlight = new Streetlight();
            streetlight.setActive(false);
            streetlightRepository.save(streetlight);
        }

        simulatedClock.addObserver(this); // Ajouter cet objet comme observateur de l'horloge simulée

        System.out.println("GestionEclairageService: Lampadaire initialisé avec isActive = false.");
    }


    @Scheduled(fixedRate = 10000) // Tâche exécutée toutes les 10 secondes
    public void updateClock() {
        System.out.println("updateClock appelé.");
        hour = (hour + 1) % 24; // Avancer l'heure simulée
        System.out.println("GestionEclairageService: Heure actuelle : " + hour + "h");
        notifyObservers(); // Notifier les observateurs
    }

    @Override
    public void update(int hour) {
        if (hour >= 19 || hour < 7) { // Si c'est entre 19h et 7h, il fait nuit
            streetlight.setActive(true); // Allumer le lampadaire
            System.out.println("Lampadaire allumé. Heure : " + hour + "h");
        } else {
            streetlight.setActive(false); // Éteindre le lampadaire pendant la journée
            System.out.println("Lampadaire éteint. Heure : " + hour + "h");
        }

        streetlightRepository.save(streetlight); // Enregistrer l'état du lampadaire
    }

    public void notifyObservers() {
        simulatedClock.notifyObservers(hour); // Notifier les observateurs
    }

    public Integer getHour() {
        return hour;
    }
}
