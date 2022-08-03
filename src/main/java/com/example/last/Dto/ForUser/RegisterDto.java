package com.example.last.Dto.ForUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    String username;
    String password;
    String password2;
}
