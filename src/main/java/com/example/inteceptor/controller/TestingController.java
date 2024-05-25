package com.example.inteceptor.controller;

import com.example.inteceptor.service.Iservice;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class TestingController {

    private final Iservice iservice;

    @GetMapping("hello")
    ResponseEntity<?> hello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("turn-on")
    ResponseEntity<?> turnOn() {
        return ResponseEntity.ok(iservice.turnOn());
    }

    @PostMapping("turn-off")
    ResponseEntity<?> turnOff() {
        return ResponseEntity.ok(iservice.turnOff());
    }
}
