package com.example.server_streetlight.service;
import com.example.server_streetlight.repository.StreetlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

@Service
public class StreetlightService {

    @Autowired
    private StreetlightRepository streetlightRepository;


}
