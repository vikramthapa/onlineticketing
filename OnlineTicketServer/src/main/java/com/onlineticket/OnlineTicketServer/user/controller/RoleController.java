package com.onlineticket.OnlineTicketServer.user.controller;


import com.onlineticket.OnlineTicketServer.user.pojo.Registration;
import com.onlineticket.OnlineTicketServer.user.pojo.Role;
import com.onlineticket.OnlineTicketServer.user.pojo.User;
import com.onlineticket.OnlineTicketServer.user.repository.RoleRepository;
import com.onlineticket.OnlineTicketServer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getAllUser() {
        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }


}

