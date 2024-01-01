package com.dreamhire.DreamHire.model;

import com.dreamhire.DreamHire.model.ro.resume.PersonalData;
import com.dreamhire.DreamHire.model.ro.resume.ResumeData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "resumes")
public class Resume {

    private String id;

    @Indexed(unique = true)
    @Field(name = "user_id")
    private int userId;

    private PersonalData personalData;

    private List<ResumeData>  resumeData;
}
