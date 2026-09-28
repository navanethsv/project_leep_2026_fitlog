package com.example.fitlog.service.Impl;

import com.example.fitlog.model.Workout;

import java.util.List;

public interface WebService {

    Object addWorkout(Workout workout);

    List<Workout> getAllWorkouts();

    Object getWorkoutById(Long id);

    Object updateWorkout(Long id, Workout workout);

    String deleteWorkout(Long id);
}
