package com.rashmi.jounalApp.service;

import com.rashmi.jounalApp.entity.JournalEntity;
import com.rashmi.jounalApp.repository.JournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class JournalAppService {

    @Autowired
    private JournalAppRepository journalAppRepository;

    public boolean createNew(JournalEntity journalEntity){
        journalAppRepository.save(journalEntity);
        return true;
    }
    public List<JournalEntity> getAllJournals(){
        return journalAppRepository.findAll();
    }
    public Optional<JournalEntity> getById(String id){
        return Optional.of((JournalEntity) journalAppRepository.findAllById(Collections.singleton(id)));

    }
    public void deleteById(String id){
        journalAppRepository.deleteById(id);

    }
}
