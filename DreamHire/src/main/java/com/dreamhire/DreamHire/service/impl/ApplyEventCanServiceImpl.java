package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.ApplyEventDto;
import com.dreamhire.DreamHire.dto.request.ApplyEventCanRequestDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.model.ApplyEventCandidate;
import com.dreamhire.DreamHire.repository.ApplyEventCandidateRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.EventRepo;
import com.dreamhire.DreamHire.service.ApplyEventCanService;
import com.dreamhire.DreamHire.util.enums.ErrorEnum;
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
        if (applyEventCandidateRepo.existsByCandidateIdAndEventId(id, applyEventCanRequestDto.getEventId())){
            throw new DreamHireException(ErrorEnum.ERROR_DUPLICATE_ID, "You have already applied this event!");
        }else {
            ApplyEventCandidate applyEventCandidate = modelMapper.map(applyEventCanRequestDto,ApplyEventCandidate.class);
            if(eventRepo.existsById(applyEventCanRequestDto.getEventId())){
                applyEventCandidate.setEvent(eventRepo.findById(applyEventCanRequestDto.getEventId()));
            }else {
                throw new DreamHireException(ErrorEnum.ERROR_INVALID_ID, "No event for this id: " + applyEventCanRequestDto.getEventId());
            }
            if(candidateRepo.existsById(id)){
                applyEventCandidate.setCandidate(candidateRepo.findById(id));
                ApplyEventCandidate savedApplyEventCandidate =  applyEventCandidateRepo.save(applyEventCandidate);
                return modelMapper.map(savedApplyEventCandidate, ApplyEventDto.class);
            }else {
                throw new DreamHireException(ErrorEnum.ERROR_INVALID_ID, "No candidate for this id: " + id);
            }
        }
    }
}
