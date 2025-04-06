package com.example.demo.repository;

import com.example.demo.model.Pin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PinRepository extends JpaRepository<Pin, Long> {
    List<Pin> findByIsMarkedTrueAndUserId(Long userId);
}
