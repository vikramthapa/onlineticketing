package com.onlineticket.OnlineTicketServer.specialist.service;

import com.onlineticket.OnlineTicketServer.specialist.pojo.Specialist;
import com.onlineticket.OnlineTicketServer.specialist.repository.SpecialistRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class SpecialistServiceImpl implements  SpecialistService{

    @Autowired
    SpecialistRepository repository;


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
