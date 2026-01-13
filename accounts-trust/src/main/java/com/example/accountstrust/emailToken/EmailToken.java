package com.example.accountstrust.emailToken;


import com.example.accountstrust.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_email_tokens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailToken {
    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCheck type;
    @Column(nullable = false, unique = true)
    private String token;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;



    //    Gestion automatique des variables de date createAt et updateAt
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
