package com.dreamhire.DreamHire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "job_posts")
public class JobPost extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobTitle;
    private String jobType;
    private String experience;
    private String education;
    private Date deadline;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String howToApply;
    @Column(columnDefinition = "TEXT")
    private String jobRequirements;
    @Column(length = 500)
    private String tags;
    private String author;
    private boolean validate;
    @Column(length = 500)
    private String cover;
    private String currency;
    private String minSalary;
    private String maxSalary;
    private int numberOfVacancies;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
