package com.dreamhire.DreamHire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
@Data
public class Event extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    @Column(length = 500)
    private String title;
    @Column(length = 4000)
    private String description;
    @Column(length = 500)
    private String cover;
    @Column(length = 4000)
    private String companies;
    private Date date;
    private Date startTime;
    private Date endTime;
    private String email;
    private String phone;
    private boolean validate= true;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
