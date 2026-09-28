package com.example.fitlog.repository;

import com.example.fitlog.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebRepository extends JpaRepository<Workout, Long> {
}
