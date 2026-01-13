package com.example.accountstrust.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
//    Requete permettant de rechercher les utilisateurs par email
    Optional<User> findByEmail(String username);
}
