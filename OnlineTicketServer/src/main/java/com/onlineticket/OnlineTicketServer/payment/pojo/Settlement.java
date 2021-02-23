package com.onlineticket.OnlineTicketServer.payment.pojo;

import com.onlineticket.OnlineTicketServer.ticket.pojo.Reservation;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

public @Data class Settlement {


        private Long reservationId;

        private String paymentSource;

        private Double amountPayable;

}

