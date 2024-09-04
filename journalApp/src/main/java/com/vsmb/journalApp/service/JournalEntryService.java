package com.vsmb.journalapp.service;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vsmb.journalapp.entity.JournalEntry;
import com.vsmb.journalapp.repository.JournalEntryRepository;
import java.util.List;

@Component
public class JournalEntryService {

  @Autowired
  private JournalEntryRepository journalEntryRepository;

  public void saveEntry(JournalEntry journalEntry) {
    try {
      journalEntryRepository.save(journalEntry);
    } catch (Exception e) {
      throw new RuntimeException("Failed to save journal entry", e);
    }
  }

  public List<JournalEntry> getAll() {
    try {
      return journalEntryRepository.findAll();
    } catch (Exception e) {
      throw new RuntimeException("Failed to fetch all journal entries", e);
    }
  }

  public Optional<JournalEntry> findById(ObjectId id) {
    try {
      return journalEntryRepository.findById(id);
    } catch (Exception e) {
      throw new RuntimeException("Failed to find journal entry by id", e);
    }
  }

  public void deleteById(ObjectId id) {
    try {
      journalEntryRepository.deleteById(id);
    } catch (Exception e) {
      throw new RuntimeException("Failed to delete journal entry", e);
    }
  }
}
