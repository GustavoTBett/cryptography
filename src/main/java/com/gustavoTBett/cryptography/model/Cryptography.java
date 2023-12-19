package com.gustavoTBett.cryptography.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "cryptography")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cryptography {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Version
    private int version;

    @Column(name = "user_document")
    private String userDocument;

    @Column(name = "credit_card_token")
    private String creditCardToken;

    @Column(name = "value")
    private Long value;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
