package com.onlineticket.OnlineTicketServer.specialist.service;

import com.onlineticket.OnlineTicketServer.specialist.pojo.Specialist;
import com.onlineticket.OnlineTicketServer.specialist.repository.SpecialistRepository;
import com.onlineticket.OnlineTicketServer.user.pojo.Role;
import com.onlineticket.OnlineTicketServer.user.pojo.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class SpecialistServiceImpl implements  SpecialistService{

    @Autowired
    SpecialistRepository repository;

    @PostConstruct // These doctors are fed for Demo purposes
    private void runBefore()
    {
        ArrayList<Specialist> doctors = new ArrayList<>();

        //Dummy Doctor 1
        doctors.add(Specialist.builder()
                .firstName("Archana")
                .lastName("Shahi Pun")
                .qualification("MD")
                .expertise("Primary Care Doctor")
                .rating(4)
                .male(false)
                .timeFrom(8)
                .timeTo(15)
                .location("Pokhara")
                .imageUrl("doctor1")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

       // Dummy Doctor 2
        doctors.add(Specialist.builder()
                .firstName("Bhola")
                .lastName("Shrestha")
                .qualification("DO")
                .expertise("Primary Care Doctor")
                .rating(4)
                .male(true)
                .timeFrom(6)
                .timeTo(11)
                .location("Pokhara")
                .imageUrl("doctor2")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

        // Dummy Doctor 3
        doctors.add(Specialist.builder()
                .firstName("Bhagwan")
                .lastName("Koirala")
                .qualification("MD")
                .expertise("Cardiothoracic Sergen")
                .rating(5)
                .male(true)
                .timeFrom(10)
                .timeTo(12)
                .location("Kathmandu")
                .imageUrl("doctor3")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

       //Dummy Doctor 4
        doctors.add(Specialist.builder()
                .firstName("Amir")
                .lastName("Neupane")
                .qualification("MD")
                .expertise("Physiotherapist")
                .rating(5)
                .male(true)
                .timeFrom(10)
                .timeTo(12)
                .location("Birgunj")
                .imageUrl("doctor4")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

        doctors.forEach(
                s-> {
                     Specialist specialist = repository.save(s);
                     if(specialist!=null)
                     log.info("Specialist Created: "+ specialist);
                }
        );

        log.info("Created Specialists: "+repository.findAll());
    }
    @Override
    public Specialist save(Specialist specialist) {
        return repository.save(specialist);
    }

    @Override
    public Optional<Specialist> getById(Long id) {
        return repository.findById(id) ;
    }

    @Override
    public List<Specialist> getAllSpecialist() {
        return repository.findAll();
    }

    @Override
    public void delete(Specialist specialist) {
        repository.delete(specialist);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
