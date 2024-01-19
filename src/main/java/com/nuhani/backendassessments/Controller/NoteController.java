package com.nuhani.backendassessments.Controller;

import com.nuhani.backendassessments.Model.Note;
import com.nuhani.backendassessments.Service.NoteService;
import com.nuhani.backendassessments.Service.RateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {


    private final NoteService noteService;
    private final RateLimiterService rateLimiterService;

    @Autowired
    public NoteController(NoteService noteService, RateLimiterService rateLimiterService) {
        this.noteService = noteService;
        this.rateLimiterService = rateLimiterService;
    }

    @GetMapping
    public List<Note> getAllNotes() {

        return validateRateLimit() ? noteService.getAllNotes() : null;
    }

    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable String id) {
        return validateRateLimit() ? noteService.getNoteById(id) : Optional.empty();
    }

    @PostMapping
    public Note createOrUpdateNote(@RequestBody Note note) {

        return validateRateLimit() ? noteService.createOrUpdateNote(note) : null;
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable String id) {

        if (validateRateLimit()) noteService.deleteNoteById(id);
    }

    private boolean validateRateLimit() {
        if (rateLimiterService.tryConsume()) {
            return true;
        } else {
            // Log an error message , for now console
            System.err.println("Rate limit exceeded!");
            // Return false or handle the rate limit exceeded case accordingly
            return false;
        }
    }
}
