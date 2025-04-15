package com.example.headingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.headingapp.model.Heading;
import com.example.headingapp.service.HeadingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/heading")
public class HeadingController {

    private final HeadingService headingService;

    @Autowired
    public HeadingController(HeadingService headingService) {
        this.headingService = headingService;
    }

    /**
     * GET API to retrieve the current heading text.
     * Returns JSON: { "heading": "..." }
     */
    @GetMapping
    public ResponseEntity<?> getHeading() {
        Heading heading = headingService.getHeading();
        return ResponseEntity.ok().body(new HeadingResponse(heading.getHeadingText()));
    }

    /**
     * POST API to update the heading text.
     * Expects JSON: { "heading": "New heading text" }
     */
    @PostMapping
    public ResponseEntity<?> updateHeading(@RequestBody HeadingRequest request) {
        Heading updated = headingService.updateHeading(request.getHeading());
        return ResponseEntity.ok().body(new HeadingResponse(updated.getHeadingText()));
    }
    
    // DTO classes for the request and response:
    
    public static class HeadingRequest {
        private String heading;

        public String getHeading() {
            return heading;
        }

        public void setHeading(String heading) {
            this.heading = heading;
        }
    }

    public static class HeadingResponse {
        private String heading;

        public HeadingResponse(String heading) {
            this.heading = heading;
        }

        public String getHeading() {
            return heading;
        }

        public void setHeading(String heading) {
            this.heading = heading;
        }
    }
}
