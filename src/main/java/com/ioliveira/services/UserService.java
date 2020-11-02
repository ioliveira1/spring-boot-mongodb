package com.ioliveira.services;

import com.ioliveira.controllers.converters.UserConverter;
import com.ioliveira.controllers.dtos.requests.UserRequestDTO;
import com.ioliveira.entities.User;
import com.ioliveira.exceptions.ObjectNotFoundException;
import com.ioliveira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User ID:" + id + " nof found"));
    }

    public User insert(UserRequestDTO requestDTO) {
        return userRepository.save(UserConverter.toEntity(requestDTO));
    }
}
