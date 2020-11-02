package com.ioliveira;

import com.ioliveira.entities.User;
import com.ioliveira.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootMongodbApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        final User u1 = User.builder().name("Odielte Martins").email("odielte@gmail.com").build();
        final User u2 = User.builder().name("Aline Lima").email("aline@gmail.com").build();
        final User u3 = User.builder().name("Igor Oliveira").email("igor@gmail.com").build();

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

    }
}
