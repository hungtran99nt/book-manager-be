package edu.ptit.wp2022.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationUserRequestDto {
    @NotNull
    @Size(max = 30)
    private String username;

    @NotNull
    @Size(max = 75)
    private String password;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @Size(max = 10)
    private String gender;

    private Date dob;

    @Size(max = 10)
    private String type = "Admin";
}
