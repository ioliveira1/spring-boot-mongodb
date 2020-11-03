package com.ioliveira.controllers.converters;

import com.ioliveira.controllers.dtos.responses.AuthorResponseDTO;
import com.ioliveira.entities.User;

public class AuthorConverter {

    public static AuthorResponseDTO toDTO(User user) {
        return AuthorResponseDTO.builder().name(user.getName()).email(user.getEmail()).build();
    }
}
