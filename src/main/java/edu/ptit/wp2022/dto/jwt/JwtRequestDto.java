package edu.ptit.wp2022.dto.jwt;

import java.io.Serializable;

public class JwtRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    /**
     * Need default constructor for JSON Parsing
     */
    public JwtRequestDto() {
        // nop
    }

    public JwtRequestDto(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
