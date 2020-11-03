package com.ioliveira.controllers;

import com.ioliveira.controllers.dtos.requests.UserRequestDTO;
import com.ioliveira.entities.Post;
import com.ioliveira.entities.User;
import com.ioliveira.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserRequestDTO requestDTO) {
        final User user = userService.insert(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserRequestDTO requestDTO) {
        userService.update(id, requestDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}/posts")
    public ResponseEntity<List<Post>> findAllPosts(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id).getPosts());
    }

}
