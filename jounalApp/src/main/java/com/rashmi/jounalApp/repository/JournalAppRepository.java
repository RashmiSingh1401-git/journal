package com.rashmi.jounalApp.repository;

import com.rashmi.jounalApp.entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalAppRepository extends MongoRepository<JournalEntity, String> {
}
