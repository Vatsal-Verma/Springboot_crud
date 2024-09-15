package com.project.firstrproject;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journel_entries")
public class journelEntry {
   @Id
    private String id;
    private String name;
    private String number;
    private LocalDateTime date;  
    public LocalDateTime getDate() {
        return date;
    }   
    public void setDate(LocalDateTime localDateTime) {
        this.date = localDateTime;
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
    public String getNumber() {
        return number;
    }public void setNumber(String number) {
        this.number = number;
    }
    public static journelEntry add(int myid, String entity) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
