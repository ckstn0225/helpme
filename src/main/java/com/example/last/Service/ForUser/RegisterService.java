package com.example.last.Service.ForUser;


import com.example.last.Dto.ForUser.RegisterDto;
import com.example.last.Entity.Auther;
import com.example.last.Repository.UserRepository;
import com.example.last.security.WebSecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RegisterService {

    private final PasswordEncoder passwordEncoder;

    private final WebSecurityConfig webSecurityConfig;

    private final UserRepository userRepository;

    public RegisterService(PasswordEncoder passwordEncoder, WebSecurityConfig webSecurityConfig, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.webSecurityConfig = webSecurityConfig;
        this.userRepository = userRepository;
    }


    public String Register(RegisterDto registerDto){
        String username = registerDto.getUsername();
        String password = registerDto.getPassword();
        String password2 = registerDto.getPassword2();
        String IDpattern = "^[a-zA-Z0-9]*$";
        String PWpattern = "^[a-z0-9]*$";
        Optional<Auther> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            return "중복된 id 입니다.";
        }
        if(!username.matches(IDpattern)||username.length()<4||username.length()>12){
            return "아이디 양식에 맞지않습니다.";
        } else if (!password.matches(PWpattern)||password.length()<4||password.length()>32) {
            return "비밀번호 양식이 맞지않습니다.";
        } else if (!password.equals(password2)) {
            return "비밀번호가 일치하지않습니다!";
        }
        String encopass = passwordEncoder.encode(registerDto.getPassword());
        Auther auther = new Auther(registerDto.getUsername(),encopass);
        userRepository.save(auther);

        return "회원가입 완료!";

    }


}
