package com.example.plateforme.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "social_channels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String provider; // "facebook" ou "linkedin"
    private String accessToken;
    private String refreshToken; // optionnel selon API
    private String profileName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters, setters, constructors
}
