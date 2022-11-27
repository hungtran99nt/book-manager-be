package edu.ptit.wp2022.controllers;

import edu.ptit.wp2022.common.JwtTokenUtil;
import edu.ptit.wp2022.common.RestApi;
import edu.ptit.wp2022.dto.jwt.JwtRequestDto;
import edu.ptit.wp2022.dto.jwt.JwtResponseDto;
import edu.ptit.wp2022.services.JwtUserDetailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailServiceImpl userDetailsService;

    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(RestApi.Auth.SIGN_IN)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest)
            throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        final String username = userDetails.getUsername();
        final Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return ResponseEntity.ok(new JwtResponseDto(token, username, authorities.iterator().next().getAuthority()));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
