package edu.ptit.wp2022.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;
    private String username;
    private String role;
}
