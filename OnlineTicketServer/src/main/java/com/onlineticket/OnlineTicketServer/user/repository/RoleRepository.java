package com.onlineticket.OnlineTicketServer.user.repository;

import com.onlineticket.OnlineTicketServer.user.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long > {

}
