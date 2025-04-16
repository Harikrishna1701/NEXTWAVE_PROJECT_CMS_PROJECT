package com.example.headingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.headingapp.model.Heading;
import com.example.headingapp.repository.HeadingRepository;

@Service
public class HeadingService {

    private final HeadingRepository headingRepository;

    @Autowired
    public HeadingService(HeadingRepository headingRepository) {
        this.headingRepository = headingRepository;
    }

    // Retrieve the heading. Assumes only one record (id=1).
    public Heading getHeading() {
        Optional<Heading> optionalHeading = headingRepository.findById(1L);
        if (optionalHeading.isPresent()) {
            return optionalHeading.get();
        } else {
            // Create the default record if it doesn't exist.
            Heading defaultHeading = new Heading("Hyper boost your Revenue Management, Marketing and Commercial Functions with Business Ready AI");
            return headingRepository.save(defaultHeading);
        }
    }

    // Update the heading text.
    public Heading updateHeading(String newHeading) {
        Heading heading = getHeading();
        heading.setHeadingText(newHeading);
        return headingRepository.save(heading);
    }
}
