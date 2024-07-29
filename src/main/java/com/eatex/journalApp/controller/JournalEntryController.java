package com.eatex.journalApp.controller;

import com.eatex.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<Long, JournalEntry>();

    @GetMapping("/GetData")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping("/Insertion")
    public boolean createEntry(@RequestBody JournalEntry entry){
         journalEntries.put(entry.getId(), entry);
         return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalIdByEntry(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalIdByEntry(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalIdByEntry(@PathVariable Long myId,@RequestBody JournalEntry entry){
        return journalEntries.put(myId, entry);
    }


}
