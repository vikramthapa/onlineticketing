package com.onlineticket.OnlineTicketServer.security.service;

import java.util.ArrayList;

import com.onlineticket.OnlineTicketServer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {
    @Autowired
    UserService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return service.loadUserByUsername(username);
        } else {
            throw new UsernameNotFoundException(username+" not found !"  );
        }
    }
}
