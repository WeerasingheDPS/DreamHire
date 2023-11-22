package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.util.enums.CandidateType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apply_job_candidate")
public class ApplyEventCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPost jobPost;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Enumerated(value = EnumType.STRING)
    private CandidateType candidateType = CandidateType.pending;
    private Date appliedDate;
    @Column(columnDefinition = "TEXT")
    private String reason;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String currency;
    private String expectSalary;
    private String jobTitle;
    @Column(length = 500)
    private String tags;
}
