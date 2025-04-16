package com.example.headingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "headings")
public class Heading {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "heading_text", nullable = false)
    private String headingText;

    // Constructors
    public Heading() {
    }

    public Heading(String headingText) {
        this.headingText = headingText;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }
}
