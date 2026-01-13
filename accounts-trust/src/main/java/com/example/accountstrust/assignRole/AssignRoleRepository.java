package com.example.accountstrust.assignRole;

import com.example.accountstrust.adminProfile.AdminProfile;
import com.example.accountstrust.adminRole.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssignRoleRepository extends JpaRepository<AssignRole, UUID> {
    List<AssignRole> findByAssignedToIdAndIsActiveTrue(UUID adminId);

    boolean existsByAssignedToAndRoleAdminAndIsActiveTrue(
            AdminProfile assignedTo,
            AdminRole roleAdmin
    );
}
