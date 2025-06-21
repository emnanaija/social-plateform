package com.example.plateforme;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Key;
import java.util.Base64;

@SpringBootApplication
public class PlateformeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlateformeApplication.class, args);

        // Génération de la clé HS512
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        // Encodage Base64 de la clé
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());

        // Affichage dans la console
        System.out.println("Clé Base64 pour HS512 : " + base64Key);
    }
}
