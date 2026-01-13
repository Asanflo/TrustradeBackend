package com.example.accountstrust.adminRolePermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssignRolePermissionRepository extends JpaRepository<AdminRolePermission, UUID> {

    List<AdminRolePermission> findByAdminRoleIdAndIsActiveTrue(UUID roleId);

}
