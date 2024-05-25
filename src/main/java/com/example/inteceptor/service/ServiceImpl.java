package com.example.inteceptor.service;

import com.example.inteceptor.model.Model;
import com.example.inteceptor.model.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ServiceImpl implements Iservice{

    private final Repository repository;
    @Override
    public Optional<Model> turnOn() {
        Optional<Model> status = repository.findByKey("INTECEPTOR");
        if (status.isPresent()) {
            Model model = status.get();

            // Assuming you want to set the status to true
            model.setStatus(true);

            // Save the updated model back to the repository
            repository.save(model);

        } else {
            return null;
        }
        return status;
    }

    @Override
    public Optional<Model> turnOff() {
        Optional<Model> status = repository.findByKey("INTECEPTOR");
        if (status.isPresent()) {
            Model model = status.get();

            // Assuming you want to set the status to true
            model.setStatus(false);

            // Save the updated model back to the repository
            repository.save(model);

        } else {
            return null;
        }
        return status;
    }
}
