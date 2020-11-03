package com.ioliveira;

import com.ioliveira.controllers.converters.AuthorConverter;
import com.ioliveira.entities.Post;
import com.ioliveira.entities.User;
import com.ioliveira.repositories.PostRepository;
import com.ioliveira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootMongodbApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        final User u1 = User.builder().name("Odielte Martins").email("odielte@gmail.com").build();
        final User u2 = User.builder().name("Aline Lima").email("aline@gmail.com").build();
        final User u3 = User.builder().name("Igor Oliveira").email("igor@gmail.com").build();

        final Post p1 = Post.builder().date(LocalDate.of(2018, 3, 21)).title("Partiu intercâmbio").body("Vou estudar inglês no Canadá. Abraços").author(AuthorConverter.toDTO(u3)).build();
        final Post p2 = Post.builder().date(LocalDate.of(2018, 3, 23)).title("Bom dia").body("Hoje começam minhas aulas").author(AuthorConverter.toDTO(u3)).build();

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        postRepository.saveAll(Arrays.asList(p1, p2));

        u3.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u3);

    }
}
