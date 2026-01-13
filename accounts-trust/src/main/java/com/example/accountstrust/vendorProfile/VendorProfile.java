package com.example.accountstrust.vendorProfile;

import com.example.accountstrust.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

//Definition de l'entite profile du vendeur
@Entity
@Table
public class VendorProfile {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(unique = true, nullable = false, updatable = false)
    private UUID id;
    private Integer rating;
    private String badge;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
//    Lors de la creation du profile, son statut par defaut est en attente
    private KycStatus kycStatus =  KycStatus.PENDING;
//    Variable pour la journalisation
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    Definition de la relation entre Profile vendeur et user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "user_id", referencedColumnName = "id")
    private User user;

    //    Gestion automatique des variables de date createAt et updateAt
    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
