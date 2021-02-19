package com.onlineticket.OnlineTicketServer.ticket.pojo;

import com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo.ParaglidingPilot;
import com.onlineticket.OnlineTicketServer.ticket.utility.PrefTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private ParaglidingPilot preferredPilot;

    private String firstName;
    private String LastName;
    private String contact;
    private String email;
    private String gender;
    private Integer age;
    private Date date ;
    private PrefTime prefTime;
    private Integer durationHour;
    private Integer durationMinute;
}
