package com.example.inteceptor.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Model, Long> {


    Optional<Model> findByKey(String key);
}
