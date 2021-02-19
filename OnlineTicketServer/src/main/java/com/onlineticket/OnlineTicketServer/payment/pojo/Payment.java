package com.onlineticket.OnlineTicketServer.payment.pojo;

import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Reservation reservation;

    private Double rate;
    private Integer noOfTickets;
    private Double AmountPayable;

}
