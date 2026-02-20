package com.rashmi.jounalApp.service;

import com.rashmi.jounalApp.entity.JournalEntity;
import com.rashmi.jounalApp.repository.JournalAppRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class JournalAppService {

    @Autowired
    private JournalAppRepository journalAppRepository;

    public boolean createNew(JournalEntity journalEntity){
        journalEntity.setDate(LocalDate.now());
        journalAppRepository.save(journalEntity);
        return true;
    }
    public List<JournalEntity> getAllJournals(){
        return journalAppRepository.findAll();
    }
    public Optional<JournalEntity> getById(ObjectId id){
        return journalAppRepository.findById(id);

    }
    public void deleteById(ObjectId id){
        journalAppRepository.deleteById(id);

    }
    public void update(JournalEntity journalEntity){
        journalAppRepository.save(journalEntity);

    }
}
