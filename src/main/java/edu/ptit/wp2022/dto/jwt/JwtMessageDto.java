package edu.ptit.wp2022.dto.jwt;

import java.io.Serializable;

public class JwtMessageDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;

    public JwtMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
