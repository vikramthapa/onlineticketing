package com.onlineticket.OnlineTicketServer.user.service;


import com.onlineticket.OnlineTicketServer.user.pojo.Registration;
import com.onlineticket.OnlineTicketServer.user.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User findByUserName(String userName);
    public User save(Registration registration);
    public Optional<User> getById(Long id);
    public List<User> getAllUser();
    public void delete(User user);
    public void deleteById(Long id);
    public UserDetails loadUserByUsername(String username);
}

