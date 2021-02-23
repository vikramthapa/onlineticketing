package com.onlineticket.OnlineTicketServer.payment.service;

import com.onlineticket.OnlineTicketServer.payment.pojo.Payment;
import com.onlineticket.OnlineTicketServer.payment.pojo.Settlement;
import com.onlineticket.OnlineTicketServer.payment.repository.PaymentRepository;
import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;
import com.onlineticket.OnlineTicketServer.ticket.repository.ReservationRepository;
import com.onlineticket.OnlineTicketServer.ticket.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    PaymentRepository repository;

    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment save(Settlement payment) {
        Double rate = 4000d;
        Reservation reservation = reservationRepository.getOne(payment.getReservationId());
                Double inHour = (reservation.getDurationMinute()>0)?
                            (reservation.getDurationMinute()/60):0.0;
                Double amountPayable = (reservation.getDurationHour()+inHour)*rate;
        Payment payment1 = Payment.builder()
                .reservation(reservation)
                .hours(reservation.getDurationHour())
                .minute(reservation.getDurationMinute())
                .rate(rate)
                .amountPayable(amountPayable)
                .paidTime(new Date())
                .onlineSource(payment.getPaymentSource())
                .build();

        return repository.save(payment1);
    }

    @Override
    public Optional<Payment> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Payment> getAllPayment() {
        return repository.findAll();
    }

    @Override
    public void delete(Payment payment) {
        repository.delete(payment);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
