package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.ApplyJobDto;
import com.dreamhire.DreamHire.dto.request.ApplyEventCanRequestDto;

public interface ApplyEventCanService {
    String save(ApplyEventCanRequestDto applyEventCanRequestDto, int id);
}
