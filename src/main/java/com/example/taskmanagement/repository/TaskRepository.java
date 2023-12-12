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
    Optional<Task> findByHeading(String heading);
    Optional<List<Task>> findByExecutor(String priority);
    Optional<List<Task>> findByAuthor(String author);
    boolean findByHeadingIsNotNull(String heading);

}
