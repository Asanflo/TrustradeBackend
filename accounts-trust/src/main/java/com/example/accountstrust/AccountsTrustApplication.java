package com.example.accountstrust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccountsTrustApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsTrustApplication.class, args);
    }

    @GetMapping("/accounts/")
    public String sayHello() {
        return "Bonjour ! Bienvenue sur AccountsTrust.";
    }
}
