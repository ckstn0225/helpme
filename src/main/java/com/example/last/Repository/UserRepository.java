package com.example.last.Repository;

import com.example.last.Entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Auther, Long> {
    Optional<Auther> findByUsername(String username);
}