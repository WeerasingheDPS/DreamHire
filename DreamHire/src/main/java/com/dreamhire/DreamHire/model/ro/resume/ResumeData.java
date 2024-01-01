package com.dreamhire.DreamHire.model.ro.resume;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeData {

    private String title;
    private String subTitle;
    private String city;
    private String country;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
}
