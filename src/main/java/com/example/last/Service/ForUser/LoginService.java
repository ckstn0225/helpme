package com.example.last.Service.ForUser;

import com.example.last.Dto.ForUser.LoginDto;
import com.example.last.Entity.Auther;
import com.example.last.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Boolean Login(LoginDto loginDto){
        Auther user = userRepository.findByUsername(loginDto.getUsername())
                .orElse(null);
        if (user != null) {
            return true;
        } else {
            return false;
        }

    }
}
