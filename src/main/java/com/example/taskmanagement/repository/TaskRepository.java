package com.example.taskmanagement.repository;

import com.example.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE heading = :heading LIMIT 1")
    Optional<Task> findByHeading(String heading);
}
