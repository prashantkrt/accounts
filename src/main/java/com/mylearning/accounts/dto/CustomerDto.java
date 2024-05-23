package com.mylearning.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 20, message = "")
    private String name;

    @NotEmpty(message = "email address cannot be empty")
    @Email(message = "email address should be valid value")
    private String email;

    @Pattern(regexp = "^$|[0-9]{10}", message = "mobile number must be 10 digits")
    private String mobileNumber;

    private AccountDto accountDto;
}
