package com.example.last.Service.ForUser;

import com.example.last.Dto.ForUser.LoginDto;
import com.example.last.Entity.Auther;
import com.example.last.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public LoginService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public Boolean Login(LoginDto loginDto){
        Auther user = userRepository.findByUsername(loginDto.getUsername())
                .orElse(null);
        if (user != null) {
            if(passwordEncoder.encode(loginDto.getPassword()).equals(user.getPassword())){
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
