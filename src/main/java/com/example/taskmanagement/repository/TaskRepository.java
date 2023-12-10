package com.example.taskmanagement.repository;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/** Репозиторий задач */
@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE heading = :heading LIMIT 1")
    Optional<Task> findByHeading(String heading);
    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE author_id = :author LIMIT 1")
    Optional<List<Task>> findByAuthor(String author);
    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE priority_id = :priority LIMIT 1")
    Optional<List<Task>> findByExecutor(String priority);
}
