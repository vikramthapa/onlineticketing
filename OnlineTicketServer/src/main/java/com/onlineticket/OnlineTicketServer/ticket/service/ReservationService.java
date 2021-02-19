package com.onlineticket.OnlineTicketServer.ticket.service;


import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    public Reservation save (Reservation reservation);
    public Optional<Reservation> getById(Long id);
    public List<Reservation> getAllReservation();
    public void delete(Reservation reservation);
    public void deleteById(Long id);
}
