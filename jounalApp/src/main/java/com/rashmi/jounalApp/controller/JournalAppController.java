package com.rashmi.jounalApp.controller;


import com.rashmi.jounalApp.entity.JournalEntity;
import com.rashmi.jounalApp.service.JournalAppService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalAppController {

    @Autowired
    private JournalAppService service;
    Map<Long, JournalEntity> journals = new HashMap<>();
    @GetMapping("/getAll")
    public List<JournalEntity> getAllJournals(){

        return service.getAllJournals();
    }
    @GetMapping("id/{myId}")
    public Optional<JournalEntity> getById(@PathVariable String myId){

        return service.getById(myId);
    }


    @PostMapping("add")
    public boolean createNew(@RequestBody JournalEntity journalEntity){
        return service.createNew(journalEntity);

    }
    @PutMapping("deleteById/{myId}")
    public boolean delete(@PathVariable String myId){
        service.deleteById(myId);
        return true;
    }
}
