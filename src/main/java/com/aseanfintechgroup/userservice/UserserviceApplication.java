package com.aseanfintechgroup.userservice;

import com.aseanfintechgroup.userservice.domain.Role;
import com.aseanfintechgroup.userservice.domain.User;
import com.aseanfintechgroup.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    // run after application has initialized to create passwordEncoder bean
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // run after application has initialized to inject the user
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {

            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_VIP"));

            userService.saveUser(new User(null, "User One", "user_one", "user1", new ArrayList<>()));
            userService.saveUser(new User(null, "User Two", "user_two", "user2", new ArrayList<>()));
            userService.saveUser(new User(null, "User Three", "user_three", "user3", new ArrayList<>()));
            userService.saveUser(new User(null, "User Four", "user_four", "user4", new ArrayList<>()));

             userService.addRoleToUser("user_one", "ROLE_USER");
            userService.addRoleToUser("user_one", "ROLE_MANAGER");

            userService.addRoleToUser("user_two", "ROLE_MANAGER");

            userService.addRoleToUser("user_three", "ROLE_ADMIN");

            userService.addRoleToUser("user_four", "ROLE_VIP");
            userService.addRoleToUser("user_four", "ROLE_ADMIN");
            userService.addRoleToUser("user_four", "ROLE_USER");
        };
    }
}
