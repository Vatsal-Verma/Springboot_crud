package com.project.firstrproject;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.bson.types.ObjectId;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/journal")
public class controllercopy{
  @Autowired
  private JournelEntryService journelEntryService;
    @GetMapping
     public List<journelEntry> getAll(){
       return journelEntryService.getall();
    }
   @PostMapping
   public journelEntry postMethodName(@RequestBody journelEntry entity) {
    entity.setDate(LocalDateTime.now());
    journelEntryService.saveEntry(entity);
    return entity;
   }

   @GetMapping("id/{myid}")
   public journelEntry getMethodName(@PathVariable String myid) {
     return journelEntryService.findById(myid).orElse(null);
   }

   @DeleteMapping("id/{myid}")
   public boolean DeleteMethodName(@PathVariable String myid) {
     journelEntryService.deleteById(myid);
     return true;
}

   @PutMapping("id/{id}")
   public journelEntry putMethodName(@PathVariable String id, @RequestBody journelEntry newEntry) {
    journelEntry Entry = journelEntryService.findById(id).orElse(null);
    if(Entry!=null){
      Entry.setName(newEntry.getName()!=null && newEntry.getName().equals("") ? newEntry.getName() : Entry.getName() );
      Entry.setNumber(newEntry.getNumber()!=null && newEntry.getNumber().equals("") ? newEntry.getNumber() : Entry.getNumber() );
    }
    journelEntryService.saveEntry(Entry);
    return Entry;
  }
   
}
