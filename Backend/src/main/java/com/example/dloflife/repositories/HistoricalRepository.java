package com.example.dloflife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dloflife.entities.Historical;


public interface HistoricalRepository extends JpaRepository<Historical, Long> {

}