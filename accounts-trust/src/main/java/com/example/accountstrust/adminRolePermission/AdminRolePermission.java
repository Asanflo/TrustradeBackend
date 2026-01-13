package com.example.accountstrust.adminRolePermission;

import com.example.accountstrust.adminRole.AdminRole;
import com.example.accountstrust.permission.Permission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "admin_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRolePermission {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_role_id", nullable = false)
    private AdminRole adminRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

    private Boolean isActive = true;
    private LocalDateTime assignedAt;

    @PrePersist
    public void onCreate() {
        this.assignedAt = LocalDateTime.now();
    }
}
