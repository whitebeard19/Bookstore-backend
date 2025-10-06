package com.bookstorelite.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank @Size(min = 3, max = 100)
    private String username;

    @NotBlank @Size(min = 6, max = 128)
    private String password;

}
