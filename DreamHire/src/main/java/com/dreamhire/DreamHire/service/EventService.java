package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.request.EventRequestDto;
import com.dreamhire.DreamHire.dto.response.EventResponseDto;
import com.dreamhire.DreamHire.model.Event;
import org.springframework.stereotype.Service;

public interface EventService {
    String save(EventRequestDto eventRequestDto, int id);

    EventResponseDto get(int id);

}
