package com.example.accountstrust.assignRole;

import com.example.accountstrust.adminProfile.AdminProfile;
import com.example.accountstrust.adminRole.AdminRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "assign_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignRole {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private LocalDateTime assignedAt;
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(nullable = false, name = "adminAssignedBy_id")
    private AdminProfile assignedBy;
    @ManyToOne
    @JoinColumn(nullable = false, name = "adminAssignedTo_id")
    private AdminProfile assignedTo;
    @ManyToOne
    @JoinColumn(nullable = false, name = "adminRole_id")
    private AdminRole roleAdmin;

    @PrePersist
    public void onCreate(){
        this.assignedAt = LocalDateTime.now();
    }
}
