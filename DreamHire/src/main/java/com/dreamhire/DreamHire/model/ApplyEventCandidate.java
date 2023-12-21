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
@Table(name = "apply_event_candidate")
public class ApplyEventCandidate extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateAddress;
}
