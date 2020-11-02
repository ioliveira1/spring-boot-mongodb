package com.ioliveira.controllers.dtos.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class UserRequestDTO {
    private String name;
    private String email;
}
