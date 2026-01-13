package com.example.accountstrust.adminRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRoleRepository extends JpaRepository<AdminRole, UUID> {

    Optional<AdminRole> findByLabel(String label);

    boolean existsByLabel(String label);
}

