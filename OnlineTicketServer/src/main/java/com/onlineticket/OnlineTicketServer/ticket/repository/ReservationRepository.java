package com.onlineticket.OnlineTicketServer.ticket.repository;

import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
