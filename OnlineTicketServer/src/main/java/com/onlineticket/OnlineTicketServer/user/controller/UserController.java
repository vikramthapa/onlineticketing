package com.onlineticket.OnlineTicketServer.user.controller;

import com.onlineticket.OnlineTicketServer.user.pojo.Registration;
import com.onlineticket.OnlineTicketServer.user.pojo.Role;
import com.onlineticket.OnlineTicketServer.user.pojo.User;
import com.onlineticket.OnlineTicketServer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> userNew(@RequestBody Registration userRegistration) {
        User user1 = service.save(userRegistration);
        if(user1!=null)
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getByUserId(@PathVariable Long id) {
        User user = service.getById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity DeleteByUserId(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
