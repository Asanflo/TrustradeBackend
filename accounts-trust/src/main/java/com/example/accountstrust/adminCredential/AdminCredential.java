package com.example.accountstrust.adminCredential;


import com.example.accountstrust.adminProfile.AdminProfile;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "admin_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminCredential {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String adminPassword;
    private LocalDateTime lastAdminLogin;
    private Boolean admin2faEnabled;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name="adminProfile_id")
    private AdminProfile adminProfile;
}
