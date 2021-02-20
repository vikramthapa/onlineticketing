package com.onlineticket.OnlineTicketServer.ticket.service;

import com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo.ParaglidingPilot;
import com.onlineticket.OnlineTicketServer.paraglidingpilot.service.ParaglidingPilotService;
import com.onlineticket.OnlineTicketServer.ticket.pojo.Book;
import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;
import com.onlineticket.OnlineTicketServer.ticket.repository.ReservationRepository;
import com.onlineticket.OnlineTicketServer.ticket.utility.PrefTime;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository repository;
    @Autowired
    ParaglidingPilotService pilotService;

    @SneakyThrows
    @Override
    public Reservation save(Book book) {
        ParaglidingPilot pilot = pilotService.getById(book.getPilotId()).get();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date bookingDate = sdf.parse(book.getDate());
        Reservation reservation = Reservation.builder()
               .firstName(book.getFirstName())
                .lastName(book.getLastName())
                .age(book.getAge())
                .gender(book.getGender())
                .contact(book.getContact())
                .email(book.getEmail())
                .preferredPilot(pilot)
                .date(bookingDate)
                .durationHour(book.getDurationHour())
                .durationMinute(book.getDurationMinute())
                .prefTime(PrefTime.AnyTime)
                .build();
        return repository.save(reservation);
    }

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
