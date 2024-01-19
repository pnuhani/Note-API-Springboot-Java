package com.nuhani.backendassessments.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Note {
    @Id
    private String id;
    private String title;
    private String content;
}

