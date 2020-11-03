package com.ioliveira.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@ToString
public class Post {
    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private User author;

    @Builder(toBuilder = true)

    public Post(LocalDate date, String title, String body, User author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}
