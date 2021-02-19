package com.onlineticket.OnlineTicketServer.paraglidingpilot.service;

import com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo.ParaglidingPilot;
import com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo.ParaglidingPilot;
import com.onlineticket.OnlineTicketServer.paraglidingpilot.repository.ParaglidingPilotRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class ParaglidingPilotServiceImpl implements ParaglidingPilotService {

    @Autowired
    ParaglidingPilotRepository repository;

    @PostConstruct // These pilots are fed for Demo purposes
    private void runBefore()
    {
        ArrayList<ParaglidingPilot> pilots = new ArrayList<>();

        //Dummy ParaglidingPilot 1
        pilots.add(ParaglidingPilot.builder()
                .firstName("Patrick")
                .lastName("Toubet")
                .expertise("APPI Pilot, XC")
                .male(true)
                .venue("Bandipur")
                .location("Tanahun")
                .imageUrl("pilot1")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

       // Dummy ParaglidingPilot 2
        pilots.add(ParaglidingPilot.builder()
                .firstName("Mathieu")
                .lastName("James")
                .expertise("APPI Master, SIV, Acro, D-Bag")
                .male(true)
                .venue("Sarangkot")
                .location("Pokhara")
                .imageUrl("pilot2")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

        // Dummy ParaglidingPilot 3
        pilots.add(ParaglidingPilot.builder()
                .firstName("David")
                .lastName("Gotham")
                .expertise("APPI Master SIV, acro, XC")
                .male(false)
                .venue("Sarangkot")
                .location("Pokhara")
                .imageUrl("pilot3")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

       //Dummy ParaglidingPilot 4
        pilots.add(ParaglidingPilot.builder()
                .firstName("Dwen")
                .lastName("Johnson")
                .expertise( "Specialised in SIV and accro courses " +
                        "and expedition")
                .male(false)
                .venue("Rangashala")
                .location("Pokhara")
                .imageUrl("pilot1")
                .about("To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.To the heated blueberries add ginger, raspberries, worcestershire sauce and shredded bagel.")
                .build());

        pilots.forEach(
                s-> {
                     ParaglidingPilot pilot = repository.save(s);
                     if(pilot!=null)
                     log.info("ParaglidingPilot Created: "+ pilot);
                }
        );

        log.info("Created ParaglidingPilots: "+repository.findAll());
    }
    @Override
    public ParaglidingPilot save(ParaglidingPilot paraglidingPilot) {
        return repository.save(paraglidingPilot);
    }

    @Override
    public Optional<ParaglidingPilot> getById(Long id) {
        return repository.findById(id) ;
    }

    @Override
    public List<ParaglidingPilot> getAllParaglidingPilot() {
        return repository.findAll();
    }

    @Override
    public void delete(ParaglidingPilot paraglidingPilot) {
        repository.delete(paraglidingPilot);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
