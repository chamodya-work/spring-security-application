package com.security.project.repository;

import com.security.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories

public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByEmail(String username);
}
