package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        System.out.println("id"+id);
        return  new ResponseEntity<>(sessionRepository.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody final Session session){
        return  new ResponseEntity<>(sessionRepository.saveAndFlush(session), HttpStatus.CREATED);
    }

   @GetMapping("/")
   public ResponseEntity list() {
       System.out.println("data");
       return  new ResponseEntity<>(sessionRepository.findAll(), HttpStatus.OK);
   }


}
