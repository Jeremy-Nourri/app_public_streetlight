package com.example.server_streetlight.service;

import com.example.server_streetlight.entity.User;
import com.example.server_streetlight.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    @Autowired
    private HttpSession _httpSession;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent() && user.get().getPassword().equals(password)) {
            _httpSession.setAttribute("user", user);
            _httpSession.setAttribute("login", "OK");
            return true;
        }
        return false;
    }
    public boolean isLogged() {
        try {
            String attrIsLogged = _httpSession.getAttribute("login").toString();
            return attrIsLogged.equals("OK");
        } catch (Exception ex) {
            return false;
        }
    }
    public User register(User user) {
        return userRepository.save(user);
    }

    public void logout() {
        _httpSession.removeAttribute("user");
        _httpSession.removeAttribute("login");
    }
}
