package edu.ptit.wp2022.dto.jwt;

import java.io.Serializable;

public class JwtResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String jwttoken;
    private String username;
    private String authority;

    public JwtResponseDto(String jwttoken, String username, String authority) {
        this.jwttoken = jwttoken;
        this.username = username;
        this.authority = authority;
    }

    public JwtResponseDto(String jwttoken) {
        setJwttoken(jwttoken);
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
