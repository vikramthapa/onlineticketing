package com.onlineticket.OnlineTicketServer.paraglidingpilot.controller;

import com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo.ParaglidingPilot;
import com.onlineticket.OnlineTicketServer.paraglidingpilot.service.ParaglidingPilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilot")
public class ParaglidingPilotController {

    @Autowired
    ParaglidingPilotService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParaglidingPilot> userNew(@RequestBody ParaglidingPilot pilot) {
        ParaglidingPilot pilot1 = service.save(pilot);
        if(pilot1!=null)
            return new ResponseEntity<>(pilot, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ParaglidingPilot>> getAllPilot() {
        return new ResponseEntity<>(service.getAllParaglidingPilot(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParaglidingPilot> getByPilotId(@PathVariable Long id) {
        ParaglidingPilot pilot = service.getById(id).get();
        return new ResponseEntity<>(pilot, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity DeleteByParaglidingPilotId(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
