package com.onlineticket.OnlineTicketServer.ticket.controller;

import com.onlineticket.OnlineTicketServer.ticket.pojo.Book;
import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;
import com.onlineticket.OnlineTicketServer.ticket.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class ReservationController {

    @Autowired
    ReservationService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> bookTicket(@RequestBody Book book) {
        Reservation ticket = service.save(book);
        if(ticket!=null)
            return new ResponseEntity<>(ticket, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reservation>> getAllReservation() {
        return new ResponseEntity<>(service.getAllReservation(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getByReservationId(@PathVariable Long id) {
        Reservation user = service.getById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}