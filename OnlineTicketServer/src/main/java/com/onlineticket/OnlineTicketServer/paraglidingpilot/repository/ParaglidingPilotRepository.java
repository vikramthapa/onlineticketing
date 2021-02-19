package com.onlineticket.OnlineTicketServer.paraglidingpilot.repository;

import com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo.ParaglidingPilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParaglidingPilotRepository extends JpaRepository<ParaglidingPilot, Long > {
}
