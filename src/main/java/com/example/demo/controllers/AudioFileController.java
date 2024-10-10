package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AudioFile;
import com.example.demo.repositories.AudioFileRepository;

@RestController
@RequestMapping("/audiofiles")
public class AudioFileController {

    @Autowired
    private AudioFileRepository audioFileRepository;

    // List all audio files
    @GetMapping
    public ResponseEntity<List<AudioFile>> getAllAudioFiles() {
        List<AudioFile> audioFiles = audioFileRepository.findAll();
        return new ResponseEntity<>(audioFiles, HttpStatus.OK);
    }

    // Get a specific audio file by ID
    @GetMapping("/{fileId}")
    public ResponseEntity<AudioFile> getAudioFileById(@PathVariable("fileId") String fileId) {
        return audioFileRepository.findById(fileId)
                .map(file -> new ResponseEntity<>(file, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new audio file
    @PostMapping
    public ResponseEntity<AudioFile> createAudioFile(@RequestBody AudioFile audioFile) {
        AudioFile savedFile = audioFileRepository.save(audioFile);
        return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
    }

    // Delete an audio file by ID
    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteAudioFileById(@PathVariable("fileId") String fileId) {
        audioFileRepository.deleteById(fileId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
