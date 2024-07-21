package com.vsmb.journalApp.controller;

import com.vsmb.journalApp.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
//    This is map is storing id and entries
    private Map<Long, JournalEntity> journalEntries = new HashMap<>();

    //This method will be return all store data
    @GetMapping                             //http://localhost:8080/journal    GET
    public List<JournalEntity> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    //this method will be inset in to map "journalEntries"
    @PostMapping                            //http://localhost:8080/journal    POST
    public boolean createEntry(@RequestBody JournalEntity myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    //this method will be return particular ID wise record
    @GetMapping("id/{myId}")                    //http://localhost:8080/journal/id/3
    public JournalEntity getJournalEntityById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    //this will be deleted recode according to ID
    @DeleteMapping("id/{myId}")             //http://localhost:8080/journal/id/3    DELETE
    public JournalEntity deleteJournalEntityById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    //this method will be updated recode according to ID.
    @PutMapping("/id/{id}")                  //http://localhost:8080/journal/id/3    PUT
    public JournalEntity updateJournalEntityById(@PathVariable Long id, @RequestBody JournalEntity myEntity){
        return journalEntries.put(id, myEntity);
    }

}
