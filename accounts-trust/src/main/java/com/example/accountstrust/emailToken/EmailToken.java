package com.example.accountstrust.emailToken;


import com.example.accountstrust.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class EmailToken {
    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCheck type;
    private String token;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;



    //    Gestion automatique des variables de date createAt et updateAt
    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
