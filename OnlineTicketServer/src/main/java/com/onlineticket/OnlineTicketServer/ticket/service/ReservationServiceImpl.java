package com.onlineticket.OnlineTicketServer.ticket.service;

import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;
import com.onlineticket.OnlineTicketServer.ticket.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository repository;
    @Override
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public Optional<Reservation> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return repository.findAll();
    }

    @Override
    public void delete(Reservation reservation) {
        repository.delete(reservation);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
