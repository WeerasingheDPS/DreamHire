package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.util.enums.CandidateStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "apply_job_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class ApplyJobCandidate{

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
    private CandidateStatus candidateType=CandidateStatus.pending;
    private Date appliedDate;
    @Column(columnDefinition = "TEXT")
    private String reason;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String currency="$USD";
    private String expectSalary="500";
    private String jobTitle;
    @Column(length = 500)
    private String tags;
}
