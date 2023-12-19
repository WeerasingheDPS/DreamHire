package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.ApplyEventDto;
import com.dreamhire.DreamHire.dto.ApplyJobDto;
import com.dreamhire.DreamHire.dto.request.ApplyEventCanRequestDto;

public interface ApplyEventCanService {
    ApplyEventDto save(ApplyEventCanRequestDto applyEventCanRequestDto, int id);
}
