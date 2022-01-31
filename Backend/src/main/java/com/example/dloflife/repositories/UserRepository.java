package com.example.dloflife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dloflife.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}