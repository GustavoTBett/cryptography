package com.gustavoTBett.cryptography.repository;

import com.gustavoTBett.cryptography.model.Cryptography;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gustavo
 */
public interface CryptographyRepository extends JpaRepository<Cryptography, Long> {
    
}
