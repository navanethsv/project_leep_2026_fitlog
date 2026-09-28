package com.example.fitlog.service.Impl.Impl;

import com.example.fitlog.model.Workout;
import com.example.fitlog.repository.WebRepository;
import com.example.fitlog.service.Impl.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private WebRepository webRepository;

    // CREATE
    @Override
    public Object addWorkout(Workout workout) {
        if (workout.getCaloriesBurnt() < 0) {
            return "Error: calories burnt cannot be negative";
        }
        return webRepository.save(workout);
    }

    // READ ALL
    @Override
    public List<Workout> getAllWorkouts() {
        return webRepository.findAll();
    }

    // READ ONE
    @Override
    public Object getWorkoutById(Long id) {
        Optional<Workout> workout = webRepository.findById(id);
        if (workout.isEmpty()) {
            return "Error: workout not found with id " + id;
        }
        return workout.get();
    }

    // UPDATE
    @Override
    public Object updateWorkout(Long id, Workout newData) {
        Optional<Workout> found = webRepository.findById(id);
        if (found.isEmpty()) {
            return "Error: workout not found with id " + id;
        }
        if (newData.getCaloriesBurnt() < 0) {
            return "Error: calories burnt cannot be negative";
        }
        Workout workout = found.get();
        workout.setType(newData.getType());
        workout.setDurationMinutes(newData.getDurationMinutes());
        workout.setCaloriesBurnt(newData.getCaloriesBurnt());
        workout.setDate(newData.getDate());
        workout.setUserId(newData.getUserId());
        return webRepository.save(workout);
    }

    // DELETE
    @Override
    public String deleteWorkout(Long id) {
        if (!webRepository.existsById(id)) {
            return "Error: workout not found with id " + id;
        }
        webRepository.deleteById(id);
        return "Workout deleted successfully";
    }
}
