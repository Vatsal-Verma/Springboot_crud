package com.project.firstrproject;

// import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class JournelEntryService {
    @Autowired
    private JournelEntryRepo journelEntryRepo;

    public void saveEntry(journelEntry journelEntry){
        journelEntryRepo.save(journelEntry);
    }
    public List<journelEntry> getall(){
        return journelEntryRepo.findAll();
    }
    public Optional<journelEntry> findById(String id ){
        return journelEntryRepo.findById(id);
    }

    public void deleteById(String id){
        journelEntryRepo.deleteById(id);
    }
}


//controller calls service , service calls repository

