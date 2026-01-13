package com.example.accountstrust.adminProfile;

import com.example.accountstrust.assignRole.AssignRole;
import com.example.accountstrust.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/*
    Definition de la classe qui va prendre va permettre de gerer les profils admin
*/
@Entity
@Table(name = "admin_profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminProfile {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String level;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    Definition de la relation existante avec user
    @OneToOne
    @JoinColumn(nullable = false)
    private User user;
    @OneToMany(mappedBy = "assignedBy", cascade = CascadeType.ALL)
    private List<AssignRole> adminAssignedBy;
    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
    private List<AssignRole> adminAssignedTo;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
