package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.request.EventRequestDto;
import com.dreamhire.DreamHire.dto.response.EventResponseDto;
import com.dreamhire.DreamHire.exception.NotFoundException;
import com.dreamhire.DreamHire.model.Event;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.EventRepo;
import com.dreamhire.DreamHire.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Override
    public String save(EventRequestDto eventRequestDto, int id) {
        Event event = modelMapper.map(eventRequestDto, Event.class);
        event.setCompany(companyRepo.findById(id));
        eventRepo.save(event);
        return "Event is saved successfully";
    }

    @Override
    public EventResponseDto get(int id) {
        if(eventRepo.existsById(id)){
            Event event = eventRepo.findById(id);
            return modelMapper.map(event, EventResponseDto.class);
        }else {
            throw new NotFoundException("Event is Not_Found");
        }

    }

}
