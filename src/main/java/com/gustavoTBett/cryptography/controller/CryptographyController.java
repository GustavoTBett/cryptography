package com.gustavoTBett.cryptography.controller;

import com.gustavoTBett.cryptography.dto.CryptographyDtoInsert;
import com.gustavoTBett.cryptography.dto.CryptographyDtoResponse;
import com.gustavoTBett.cryptography.model.Cryptography;
import com.gustavoTBett.cryptography.repository.CryptographyRepository;
import com.gustavoTBett.cryptography.service.CryptographyService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gustavo
 */
@RestController
@RequestMapping("")
public class CryptographyController {
    
    @Autowired
    private CryptographyRepository cryptographyRepository;
    
    @Autowired
    private CryptographyService cryptographyService;
    
    @PostMapping
    public ResponseEntity post(@RequestBody CryptographyDtoInsert cryptographyDto) throws Exception {
        Cryptography cryptography = cryptographyService.save(cryptographyDto);
        CryptographyDtoResponse cryptographyDtoResponse = new CryptographyDtoResponse(cryptography.getId(), cryptographyService.decrypt(cryptography.getUserDocument()),
                cryptographyService.decrypt(cryptography.getCreditCardToken()), cryptography.getValue());
        return ResponseEntity.status(201).body(cryptographyDtoResponse);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long cryptographyId) throws Exception {
        Optional<Cryptography> cryptography = cryptographyRepository.findById(cryptographyId);
        if (cryptography.isPresent()) {
            CryptographyDtoResponse cryptographyDtoResponse = new CryptographyDtoResponse(cryptography.get().getId(), cryptographyService.decrypt(cryptography.get().getUserDocument()),
                cryptographyService.decrypt(cryptography.get().getCreditCardToken()), cryptography.get().getValue());
            return ResponseEntity.status(200).body(cryptographyDtoResponse);
        } else {
            return ResponseEntity.status(404).body("Entidade não encontrada no banco de dados");
        }
    }
}
