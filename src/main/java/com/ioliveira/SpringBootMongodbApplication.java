package com.ioliveira;

import com.ioliveira.controllers.converters.AuthorConverter;
import com.ioliveira.controllers.dtos.responses.AuthorResponseDTO;
import com.ioliveira.controllers.dtos.responses.CommentResponseDTO;
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

        final AuthorResponseDTO author = AuthorResponseDTO.builder().name("Odielte Martins").email("odielte@gmail.com").build();
        final CommentResponseDTO c1 = CommentResponseDTO.builder().text("Bons estudos").dateTime(LocalDate.of(2018, 3, 21)).authorDTO(author).build();
        final CommentResponseDTO c2 = CommentResponseDTO.builder().text("Saudades").dateTime(LocalDate.of(2018, 3, 21)).authorDTO(author).build();

        p1.getCommentDTO().addAll(Arrays.asList(c1, c2));

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        postRepository.saveAll(Arrays.asList(p1, p2));

        u3.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u3);

    }
}
