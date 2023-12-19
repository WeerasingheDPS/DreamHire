package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.request.EventRequestDto;
import com.dreamhire.DreamHire.dto.response.EventResponseDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
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
    public EventResponseDto save(EventRequestDto eventRequestDto, int id) {
        Event event = modelMapper.map(eventRequestDto, Event.class);
        event.setCompany(companyRepo.findById(id));
        Event savedEvent = eventRepo.save(event);
        return modelMapper.map(savedEvent, EventResponseDto.class);
    }

    @Override
    public EventResponseDto get(int id) {
        if(eventRepo.existsById(id)){
            Event event = eventRepo.findById(id);
            return modelMapper.map(event, EventResponseDto.class);
        }else {
            throw new DreamHireException("Event is Not_Found");
        }

    }

}
