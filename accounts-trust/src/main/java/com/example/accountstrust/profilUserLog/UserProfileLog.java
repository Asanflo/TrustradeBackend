package com.example.accountstrust.profilUserLog;

import com.example.accountstrust.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_profile_logs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileLog {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String description;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String oldValue;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String newValue;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionType actionType;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
