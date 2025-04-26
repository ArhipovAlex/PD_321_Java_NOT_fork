package com.example.springdatajpa2.repository;

import com.example.springdatajpa2.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionRepository extends JpaRepository<Direction,Short> {
}
