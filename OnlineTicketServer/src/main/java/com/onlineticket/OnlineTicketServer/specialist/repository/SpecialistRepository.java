package com.onlineticket.OnlineTicketServer.specialist.repository;

import com.onlineticket.OnlineTicketServer.specialist.pojo.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long > {
}
