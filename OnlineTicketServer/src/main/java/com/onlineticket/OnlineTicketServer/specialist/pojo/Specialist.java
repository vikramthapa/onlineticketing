package com.onlineticket.OnlineTicketServer.specialist.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data
class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long spid;
    private String firstName;
    private String lastName;
    private Boolean male;
    private String qualification;
    private String expertise;
    private String location;
    private Integer timeFrom;
    private Integer timeTo;
    private Integer rating;
    private String about;
    private String imageUrl;
}
