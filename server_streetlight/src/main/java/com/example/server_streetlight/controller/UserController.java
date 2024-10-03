//package com.example.server_streetlight.controller;
//
//import com.example.server_streetlight.entity.User;
//import com.example.server_streetlight.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/signin")
//    public ResponseEntity<Map<String, Object>> signin(@RequestBody User user) {
//        if (userService.createUser(user)) {
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "User created successfully");
//            return ResponseEntity.status(201).body(response);
//        } else {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("error", "User already exists or invalid data");
//            return ResponseEntity.badRequest().body(errorResponse);
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
//        if (userService.checkUserNameExists(user.getEmail()) && userService.verifyUser(user.getEmail(), user.getPassword())) {
//            Map<String, Object> response = new HashMap<>();
//            String token = userService.generateToken(user.getEmail(), user.getPassword());
//            response.put("token", token);
//            return ResponseEntity.ok(response);
//        } else {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("error", "Invalid email or password");
//            return ResponseEntity.badRequest().body(errorResponse);
//        }
//    }
//}
