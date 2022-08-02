package com.example.last.Controller;

import com.example.last.Dto.ForUser.LoginDto;
import com.example.last.Dto.ForUser.RegisterDto;
import com.example.last.Service.ForUser.LoginService;
import com.example.last.Service.ForUser.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final RegisterService registerService;

    private final LoginService loginService;

    public UserController(RegisterService registerService, LoginService loginService) {
        this.registerService = registerService;
        this.loginService = loginService;
    }
//  회원가입
    @ResponseBody
    @PostMapping("/user/register")
    public String regist(@RequestBody RegisterDto registerDto){
        return registerService.Register(registerDto);
    }

//    로그인
    @ResponseBody
    @PostMapping("/user/login")
    public Boolean login(@RequestBody LoginDto loginDto){
        return loginService.Login(loginDto);
    }

}
