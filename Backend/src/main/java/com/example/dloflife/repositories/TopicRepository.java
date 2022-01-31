package com.example.dloflife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dloflife.entities.Topic;


public interface TopicRepository extends JpaRepository<Topic, Long> {

}