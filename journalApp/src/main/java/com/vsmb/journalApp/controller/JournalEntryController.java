package com.vsmb.journalapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vsmb.journalapp.entity.JournalEntry;
import com.vsmb.journalapp.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

  @Autowired
  private JournalEntryService journalEntryService;

  @GetMapping("/health")
  public String healthChecker() {
    return "Ok";
  }

  @GetMapping("/display")
  public List<JournalEntry> getAll() {
    return journalEntryService.getAll();
  }

  @PostMapping
  public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
    myEntry.setDate(LocalDateTime.now());
    journalEntryService.saveEntry(myEntry);
    return myEntry;
  }

  @GetMapping("id/{myId}")
  public ResponseEntity<JournalEntry> getJournalEntityById(@PathVariable ObjectId myId) {
    return journalEntryService.findById(myId)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @DeleteMapping("id/{myId}")
  public ResponseEntity<Void> deleteJournalEntityById(@PathVariable ObjectId myId) {
    if (journalEntryService.findById(myId).isPresent()) {
      journalEntryService.deleteById(myId);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PutMapping("/id/{id}")
  public ResponseEntity<JournalEntry> updateJournalEntityById(@PathVariable ObjectId id,
      @RequestBody JournalEntry myEntity) {
    return journalEntryService.findById(id)
        .map(oldEntry -> {
          oldEntry.setTitle(myEntity.getTitle() != null && !myEntity.getTitle().isEmpty() ? myEntity.getTitle()
              : oldEntry.getTitle());
          oldEntry.setContent(myEntity.getContent() != null && !myEntity.getContent().isEmpty() ? myEntity.getContent()
              : oldEntry.getContent());
          journalEntryService.saveEntry(oldEntry);
          return ResponseEntity.ok(oldEntry);
        })
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

}
