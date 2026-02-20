package com.rashmi.jounalApp.controller;


import com.rashmi.jounalApp.entity.JournalEntity;
import com.rashmi.jounalApp.service.JournalAppService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalAppController {

    @Autowired
    private JournalAppService service;

    @GetMapping("/getAll")
    public List<JournalEntity> getAllJournals(){
        return service.getAllJournals();
    }
    @GetMapping("/id/{myId}")
    public ResponseEntity<Optional<JournalEntity>> getById(@PathVariable ObjectId myId){
        if(service.getById(myId).isPresent()){
            return new ResponseEntity<>(service.getById(myId), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/add")
    public boolean createNew(@RequestBody JournalEntity journalEntity){
        return service.createNew(journalEntity);

    }
    @DeleteMapping("/id/{myId}")
    public boolean delete(@PathVariable ObjectId myId){
        service.deleteById(myId);
        return true;
    }
    @PutMapping("/id/{myId}")
    public JournalEntity update(@PathVariable ObjectId myId,@RequestBody JournalEntity  newEntity){
        JournalEntity old = service.getById(myId).orElse(null);
        if(null != old) {
            old.setName(newEntity.getName());
            old.setContent(newEntity.getContent());
        }
        service.update(old);
        return old;
    }
}
