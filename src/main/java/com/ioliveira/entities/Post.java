package com.ioliveira.entities;

import com.ioliveira.controllers.dtos.responses.AuthorResponseDTO;
import com.ioliveira.controllers.dtos.responses.CommentResponseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class Post {
    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorResponseDTO author;
    private List<CommentResponseDTO> commentDTO = new ArrayList<>();

    @Builder(toBuilder = true)

    public Post(LocalDate date, String title, String body, AuthorResponseDTO author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}
