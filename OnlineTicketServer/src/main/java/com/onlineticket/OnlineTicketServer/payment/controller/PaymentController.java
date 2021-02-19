package com.onlineticket.OnlineTicketServer.payment.controller;

import com.onlineticket.OnlineTicketServer.payment.pojo.Payment;
import com.onlineticket.OnlineTicketServer.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> executePayment(@RequestBody Payment reservation) {
        Payment payment = service.save(reservation);
        if(payment!=null)
            return new ResponseEntity<>(payment, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Payment>> getAllPayment() {
        return new ResponseEntity<>(service.getAllPayment(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> getByPaymentId(@PathVariable Long id) {
        Payment user = service.getById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

