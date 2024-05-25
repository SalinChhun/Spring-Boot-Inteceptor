package com.example.inteceptor.service;

import com.example.inteceptor.model.Model;

import java.util.Optional;

public interface Iservice {

    public Optional<Model> turnOn();

    public Optional<Model> turnOff();
}
