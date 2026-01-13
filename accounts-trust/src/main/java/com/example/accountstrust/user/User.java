package com.example.accountstrust.user;

import com.example.accountstrust.emailToken.EmailToken;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
    private Integer trust_score;
    @Column(nullable = false)
    private Boolean isActive = true;
    @Column(nullable = false)
    private Boolean isSuspended = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime last_login_at;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private UserRank rank;
/*
    Definition de la relation entre les tokens de verifications et l'entite
    utilisateur pour permettre d'eviter des erreurs de comprehension et indiquer la
    classe proprietaire de la relation a savoir EmailToken
*/
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List <EmailToken> emailTokens = new ArrayList<>();

//    Gestion automatique des variables de date createAt et updateAt
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
