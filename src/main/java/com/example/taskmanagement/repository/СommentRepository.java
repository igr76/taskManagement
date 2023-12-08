package com.example.taskmanagement.repository;

import com.example.taskmanagement.entity.СommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface СommentRepository extends JpaRepository<СommentEntity,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM comments WHERE task_id = :id ")
    List<СommentEntity> findByTaskId(int id);
}
