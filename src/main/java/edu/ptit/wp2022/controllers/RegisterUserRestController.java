package edu.ptit.wp2022.controllers;

import edu.ptit.wp2022.common.RestApi;
import edu.ptit.wp2022.dto.user.RegistrationUserRequestDto;
import edu.ptit.wp2022.exceptions.BusinessException;
import edu.ptit.wp2022.models.User;
import edu.ptit.wp2022.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class RegisterUserRestController {
    private final UserServices userServices;

    public RegisterUserRestController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping(RestApi.Auth.SIGN_UP)
    public ResponseEntity registerUser(@RequestBody @Valid RegistrationUserRequestDto requestDto) {
        return ResponseEntity.ok(userServices.register(requestDto));
    }
}
