package com.onlineticket.OnlineTicketServer.user.repository;

import com.onlineticket.OnlineTicketServer.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    User findByUserName(String username);
}
