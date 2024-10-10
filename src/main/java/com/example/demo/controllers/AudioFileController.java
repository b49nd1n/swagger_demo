package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/audiofiles")
public class AudioFileController {

    // List all audio files
    @GetMapping
    public ResponseEntity<List<String>> getAllAudioFiles() {
        List<String> audioFiles = new ArrayList<>(); // This should be replaced with real data
        return new ResponseEntity<>(audioFiles, HttpStatus.OK);
    }

    // Get a specific audio file by ID
    @GetMapping("/{fileId}")
    public ResponseEntity<String> getAudioFileById(@PathVariable("fileId") String fileId) {
        // This should fetch the file by ID from a real data source
        return new ResponseEntity<>("Audio File content for ID: " + fileId, HttpStatus.OK);
    }

    // Create a new audio file
    @PostMapping
    public ResponseEntity<String> createAudioFile(@RequestBody String audioFile) {
        // This should add a new audio file
        return new ResponseEntity<>("Audio file created: " + audioFile, HttpStatus.CREATED);
    }

    // Delete an audio file by ID
    @DeleteMapping("/{fileId}")
    public ResponseEntity<String> deleteAudioFileById(@PathVariable("fileId") String fileId) {
        // This should delete the file by ID from a real data source
        return new ResponseEntity<>("Audio File deleted for ID: " + fileId, HttpStatus.NO_CONTENT);
    }
}
