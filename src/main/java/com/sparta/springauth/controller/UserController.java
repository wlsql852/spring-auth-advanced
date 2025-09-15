package com.sparta.springauth.controller;

import com.sparta.springauth.dto.SignupRequestDto;
import com.sparta.springauth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/user/signup" )
    public String signup(SignupRequestDto requestDto) {
        // 회원가입 로직 처리 (예: 서비스 호출)
        userService.signup(requestDto);
        return "redirect:/api/user/login-page"; // 회원가입 후 로그인 페이지로 리다이렉트
    }
}
