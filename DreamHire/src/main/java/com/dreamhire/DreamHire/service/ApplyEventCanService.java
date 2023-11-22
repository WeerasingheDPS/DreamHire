package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.ApplyJobDto;

public interface ApplyEventCanService {
    String save(ApplyJobDto applyJobDto, int id);
}
