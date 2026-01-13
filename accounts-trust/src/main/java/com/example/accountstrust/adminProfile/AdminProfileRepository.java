package com.example.accountstrust.adminProfile;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminProfileRepository extends JpaRepository<AdminProfile, UUID> {


    Optional<AdminProfile> findByLevel(String level);

    boolean existsByLevel(String level);
}
