package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.ApplyEventDto;
import com.dreamhire.DreamHire.dto.ApplyJobDto;
import com.dreamhire.DreamHire.dto.request.ApplyEventCanRequestDto;
import com.dreamhire.DreamHire.model.ApplyEventCandidate;
import com.dreamhire.DreamHire.repository.ApplyEventCandidateRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.EventRepo;
import com.dreamhire.DreamHire.service.ApplyEventCanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyEventCanServiceImpl implements ApplyEventCanService {

    @Autowired
    private ApplyEventCandidateRepo applyEventCandidateRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private EventRepo eventRepo;


    @Override
    public ApplyEventDto save(ApplyEventCanRequestDto applyEventCanRequestDto, int id) {
        ApplyEventCandidate applyEventCandidate = modelMapper.map(applyEventCanRequestDto, ApplyEventCandidate.class);
        applyEventCandidate.setCandidate(candidateRepo.findById(id));
        applyEventCandidate.setEvent(eventRepo.findById(applyEventCanRequestDto.getEventId()));
        ApplyEventCandidate saveApplyEventCandidate = applyEventCandidateRepo.save(applyEventCandidate);
        return modelMapper.map(saveApplyEventCandidate, ApplyEventDto.class);
    }
}
