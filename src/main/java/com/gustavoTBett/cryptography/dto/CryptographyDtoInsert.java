package com.gustavoTBett.cryptography.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gustavo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptographyDtoInsert {
    private String userDocument;
    private String creditCardToken;
    private Long value;
}
