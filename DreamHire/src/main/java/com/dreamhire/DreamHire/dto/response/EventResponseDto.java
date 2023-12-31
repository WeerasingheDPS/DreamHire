package com.dreamhire.DreamHire.dto.response;

import com.dreamhire.DreamHire.model.Company;
import lombok.Data;

import java.util.Date;

@Data
public class EventResponseDto {

    private int id;
    private String author;
    private String title;
    private String description;
    private String cover;
    private String companies;
    private Date date;
    private Date postedDate;
    private Date startTime;
    private Date endTime;
    private String email;
    private String phone;
    private boolean validate;
    private Company company;
}
