package com.onlineticket.OnlineTicketServer.specialist.controller;

import com.onlineticket.OnlineTicketServer.specialist.pojo.Specialist;
import com.onlineticket.OnlineTicketServer.specialist.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class SpecialistController {

    @Autowired
    SpecialistService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Specialist> userNew(@RequestBody Specialist specialist) {
        Specialist specialist1 = service.save(specialist);
        if(specialist1!=null)
            return new ResponseEntity<>(specialist, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Specialist>> getAllSpecialist() {
        return new ResponseEntity<>(service.getAllSpecialist(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Specialist> getBySpecialistId(@PathVariable Long id) {
        Specialist specialist = service.getById(id).get();
        return new ResponseEntity<>(specialist, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity DeleteBySpecialistId(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
