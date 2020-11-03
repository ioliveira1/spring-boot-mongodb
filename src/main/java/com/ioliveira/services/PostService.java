package com.ioliveira.services;

import com.ioliveira.entities.Post;
import com.ioliveira.exceptions.ObjectNotFoundException;
import com.ioliveira.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post ID: " + id + " not found"));
    }

}
