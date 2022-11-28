package edu.ptit.wp2022.services;

import edu.ptit.wp2022.dto.user.RegistrationUserRequestDto;
import edu.ptit.wp2022.dto.user.UserDto;
import edu.ptit.wp2022.exceptions.BusinessException;
import edu.ptit.wp2022.models.User;
import edu.ptit.wp2022.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServices(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto getUserById(Integer id) {
        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found."));
        return modelMapper.map(user, UserDto.class);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getCurrentUser() {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto register(RegistrationUserRequestDto requestDto) {
        Optional<User> user = getUserByUsername(requestDto.getUsername());
        if (user.isPresent())
            throw new BusinessException(HttpStatus.BAD_REQUEST, "Username existed");

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(encodedPassword);
        User newUser = modelMapper.map(requestDto, User.class);
        User createdUser = userRepository.save(newUser);
        return modelMapper.map(createdUser, UserDto.class);
    }
}
