package com.ioliveira.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@ToString
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String email;

    @Builder(toBuilder = true)
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
