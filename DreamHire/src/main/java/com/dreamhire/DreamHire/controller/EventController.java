package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.request.EventRequestDto;
import com.dreamhire.DreamHire.dto.response.EventResponseDto;
import com.dreamhire.DreamHire.service.EventService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PreAuthorize("hasAnyRole('COMPANY', 'ACCOUNT')")
    @PostMapping("/save/{id}")
    public ResponseEntity<StandardResponse> saveEvent(@PathVariable int id, @RequestBody EventRequestDto eventRequestDto) {
        EventResponseDto eventResponse = eventService.save(eventRequestDto, id);
        return new ResponseEntity<StandardResponse>(
                StandardResponse
                        .builder()
                        .result(eventResponse)
                        .success(true)
                        .build(), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getEvent(@PathVariable int id) {
        EventResponseDto event = eventService.get(id);
        return new ResponseEntity<StandardResponse>(
                StandardResponse
                        .builder()
                        .result(null)
                        .success(true)
                        .build(), HttpStatus.OK
        );
    }
}