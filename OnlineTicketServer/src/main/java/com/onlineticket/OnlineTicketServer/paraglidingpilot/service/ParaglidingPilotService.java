package com.onlineticket.OnlineTicketServer.paraglidingpilot.service;

import com.onlineticket.OnlineTicketServer.paraglidingpilot.pojo.ParaglidingPilot;

import java.util.List;
import java.util.Optional;

public interface ParaglidingPilotService {
    public ParaglidingPilot save(ParaglidingPilot paraglidingPilot);
    public Optional<ParaglidingPilot> getById(Long id);
    public List<ParaglidingPilot> getAllParaglidingPilot();
    public void delete(ParaglidingPilot paraglidingPilot);
    public void deleteById(Long id);
}
