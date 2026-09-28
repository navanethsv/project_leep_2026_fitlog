package com.example.fitlog.controller;

import com.example.fitlog.model.Workout;
import com.example.fitlog.service.Impl.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    private WebService webService;

    @PostMapping("/workouts/add")
    public Object addWorkout(@RequestBody Workout workout) {
        return webService.addWorkout(workout);
    }

    @GetMapping("/workouts")
    public List<Workout> getAllWorkouts() {
        return webService.getAllWorkouts();
    }

    @GetMapping("/workouts/{id}")
    public Object getWorkoutById(@PathVariable Long id) {
        return webService.getWorkoutById(id);
    }

    @PostMapping("/workouts/update/{id}")
    public Object updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        return webService.updateWorkout(id, workout);
    }

    @PostMapping("/workouts/delete/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        return webService.deleteWorkout(id);
    }
}