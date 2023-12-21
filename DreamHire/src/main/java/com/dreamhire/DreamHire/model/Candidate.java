package com.dreamhire.DreamHire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance
public class Candidate extends SystemUser {

    private String title;

    private LocalDateTime birthday;

    private String city;

    private String name;

    private boolean visible = true;

    private String profilePicture;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String phone;

    @Column(length = 500)
    private String address;

    @Column(length = 500)
    private String facebook;

    @Column(length = 500)
    private String twitter;

    @Column(length = 500)
    private String linkedIn;

    private String currency;

    private String minSalary;

    private String maxSalary;
}
