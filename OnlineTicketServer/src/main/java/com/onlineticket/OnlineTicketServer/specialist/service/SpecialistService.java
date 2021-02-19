package com.onlineticket.OnlineTicketServer.specialist.service;

import com.onlineticket.OnlineTicketServer.specialist.pojo.Specialist;

import java.util.List;
import java.util.Optional;

public interface SpecialistService {
    public Specialist save(Specialist specialist);
    public Optional<Specialist> getById(Long id);
    public List<Specialist> getAllSpecialist();
    public void delete(Specialist specialist);
    public void deleteById(Long id);
}
