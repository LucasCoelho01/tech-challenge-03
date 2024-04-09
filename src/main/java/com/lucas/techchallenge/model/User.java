package com.lucas.techchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
