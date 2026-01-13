package com.example.accountstrust.adminCredential;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminCredentialRepository extends JpaRepository<AdminCredential, UUID> {


    Optional<AdminCredential> findById(UUID id);
}
