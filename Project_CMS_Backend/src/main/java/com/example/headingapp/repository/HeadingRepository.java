package com.example.headingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.headingapp.model.Heading;

@Repository
public interface HeadingRepository extends JpaRepository<Heading, Long> {
    // We will use the single record (record id = 1) to update or read the heading text.
}
