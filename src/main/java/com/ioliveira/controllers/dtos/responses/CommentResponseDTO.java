package com.ioliveira.controllers.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class CommentResponseDTO {
    private String text;
    private LocalDate dateTime;
    private AuthorResponseDTO authorDTO;
}
