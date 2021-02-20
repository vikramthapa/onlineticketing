package com.onlineticket.OnlineTicketServer.ticket.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data
class Book {

    private Long pilotId;
    private String firstName;
    private String LastName;
    private String contact;

    //"?:[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])"
    private String email;

    private String gender;
    private Integer age;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String date ;

    private String prefTime;

    @Min(1) //Minimum of 1 hour booking
    @Max(10) //Maximum of 10 hour booking
    private Integer durationHour;
    @Min(10) //Minimum of 10 Minute
    @Max(60) //Maximum of 60 Minute
    private Integer durationMinute;
}
