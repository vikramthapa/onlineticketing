package com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data
class ParaglidingPilot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ptid;

    private String firstName;
    private String lastName;
    private Boolean male;
    private Boolean licensed;
    private String expertise;
    private String venue;
    private String location;
    @Lob
    private String about;
    private String imageUrl;
}
