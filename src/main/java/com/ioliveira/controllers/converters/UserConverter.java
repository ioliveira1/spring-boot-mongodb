package com.ioliveira.controllers.converters;

import com.ioliveira.controllers.dtos.requests.UserRequestDTO;
import com.ioliveira.entities.User;

public class UserConverter {

    public static User toEntity(UserRequestDTO requestDTO) {
        return User.builder()
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .build();
    }

}
