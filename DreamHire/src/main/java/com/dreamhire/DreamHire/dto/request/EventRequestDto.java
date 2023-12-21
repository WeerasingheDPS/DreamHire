package com.dreamhire.DreamHire.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventRequestDto {
    private int id;
    private String author;
    private String title;
    private String description;
    private String cover;
    private String companies;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String email;
    private String phone;
    private boolean validate = true;
}
