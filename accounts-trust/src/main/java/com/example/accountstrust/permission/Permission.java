package com.example.accountstrust.permission;

import com.example.accountstrust.adminRolePermission.AdminRolePermission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Permission {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String code;
    private String description;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
    private List<AdminRolePermission> roles = new ArrayList<>();
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
