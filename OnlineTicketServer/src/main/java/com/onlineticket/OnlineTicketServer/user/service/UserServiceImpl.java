package com.onlineticket.OnlineTicketServer.user.service;

import com.onlineticket.OnlineTicketServer.user.pojo.Registration;
import com.onlineticket.OnlineTicketServer.user.pojo.Role;
import com.onlineticket.OnlineTicketServer.user.pojo.User;
import com.onlineticket.OnlineTicketServer.user.repository.RoleRepository;
import com.onlineticket.OnlineTicketServer.user.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JdbcTemplate db;

    @PostConstruct
    private void runAfter()
    {
        if(roleRepository.findAll().size()<2)
        {
            db.batchUpdate("delete from users_roles","delete from user","delete from role");
            String roles[] = {"ADMIN","USER"};
            Arrays.stream(roles).forEach(
                    s-> {
                        Role r = roleRepository.save(new Role(s));
                        if(s=="USER")
                            if(r!=null)
                            {
                                User user = new User();
                                user.setUserName("admin");
                                user.setFirstName("System");
                                user.setLastName("Administrator");
                                user.setEmail("info@cotiviti.com");
                                user.setPassword(passwordEncoder.encode("password"));
                                user.setRoles(Arrays.asList(new Role("SUPERUSER")));
                                repository.save(user);
                            }
                    }
            );

            log.info("Default Roles: "+roleRepository.findAll());
            log.info("Default User: "+repository.findAll());
        }
    }
    @Override
    public User findByUserName(String username) {

        return repository.findByUserName(username);
    }

    @Override
    public User save(Registration registration)
    {
        Role role = roleRepository.findById(registration.getRoleId()).get();

        User user = new User();
        user.setUserName(registration.getUserName());
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(role));
        return repository.save(user);
    }

    public Optional<User> getById(Long id)
    {
        return repository.findById(id);
    }
    public List<User> getAllUser()
    {
        return repository.findAll();
    }
    public void delete(User user)
    {
        repository.delete(user);
    }
    public void deleteById(Long id)
    {
        repository.deleteById(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
