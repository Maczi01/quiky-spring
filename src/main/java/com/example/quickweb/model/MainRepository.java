package com.example.quickweb.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<Person, Long> {
}