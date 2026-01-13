package com.example.accountstrust.adminRole;

import com.example.accountstrust.adminRolePermission.AdminRolePermission;
import com.example.accountstrust.assignRole.AssignRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "admin_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRole {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String label;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "roleAdmin", cascade = CascadeType.ALL)
    private List<AssignRole> assignRoles = new ArrayList<>();

    @OneToMany(mappedBy = "adminRole", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdminRolePermission> permissions = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
