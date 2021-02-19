package com.onlineticket.OnlineTicketServer.payment.service;


import com.onlineticket.OnlineTicketServer.payment.pojo.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    public Payment save (Payment payment);
    public Optional<Payment> getById(Long id);
    public List<Payment> getAllPayment();
    public void delete(Payment payment);
    public void deleteById(Long id);
}
