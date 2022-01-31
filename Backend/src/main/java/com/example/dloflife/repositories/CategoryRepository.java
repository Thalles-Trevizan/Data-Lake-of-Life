package com.example.dloflife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dloflife.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}