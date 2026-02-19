package com.rashmi.jounalApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "journal-entries")
public class JournalEntity {
    @Id
    String id;
    String name;
    String content;

    public JournalEntity(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return "JournalEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
