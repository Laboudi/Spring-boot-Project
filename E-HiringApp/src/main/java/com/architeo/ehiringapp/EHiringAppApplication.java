package com.architeo.ehiringapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EHiringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EHiringAppApplication.class, args);
    }

    /*@Bean
    CommandLineRunner run(UserServiceImpl userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Travolta", "john", "1234", new HashSet<>()));
            userService.saveUser(new User(null, "Will Smith", "will", "1234", new HashSet<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new HashSet<>()));
            userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold", "1234", new HashSet<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("will", "ROLE_MANAGER");
            userService.addRoleToUser("jim", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_USER");
        };
    }

     */

}
