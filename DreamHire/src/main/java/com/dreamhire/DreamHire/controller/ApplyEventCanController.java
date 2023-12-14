package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.ApplyJobDto;
import com.dreamhire.DreamHire.dto.request.ApplyEventCanRequestDto;
import com.dreamhire.DreamHire.service.ApplyEventCanService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/applyevent")
public class ApplyEventCanController {


    @Autowired
    private ApplyEventCanService applyEventCanService;

    @PreAuthorize("hasRole('CANDIDATE')")
    @PostMapping("/save/{id}")
    public ResponseEntity<StandardResponse> save(@PathVariable int id, @RequestBody ApplyEventCanRequestDto applyEventCanRequestDto){
        String message = applyEventCanService.save(applyEventCanRequestDto, id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, message, null, 201), HttpStatus.CREATED
        );
    }
}
