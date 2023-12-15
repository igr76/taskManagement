package com.example.taskmanagement.repository;

import com.example.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/** Репозиторий пользователей */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByLogin(String login);
    boolean findByLoginIsNotNull(String login);
}
