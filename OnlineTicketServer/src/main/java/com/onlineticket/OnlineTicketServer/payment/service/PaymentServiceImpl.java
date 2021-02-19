package com.onlineticket.OnlineTicketServer.payment.service;

import com.onlineticket.OnlineTicketServer.payment.pojo.Payment;
import com.onlineticket.OnlineTicketServer.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repository;

    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
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
