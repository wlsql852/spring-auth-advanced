package com.sparta.springauth.controller;

import com.sparta.springauth.dto.LoginRequestDto;
import com.sparta.springauth.dto.SignupRequestDto;
import com.sparta.springauth.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

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

    @PostMapping("/user/login" )
    public String login(LoginRequestDto requestDto, HttpServletResponse res) {
        try {
            // 로그인 로직 처리 (예: 서비스 호출)
            userService.login(requestDto, res);
        } catch (Exception e) {
            return "redirect:/api/user/login-page?error"; // 로그인 실패 시 다시 로그인 페이지로 리다이렉트  //오류날시 표시하자고 클라이언트와 약속
        }

        return "redirect:/"; // 로그인 후 메인 페이지로 리다이렉트
    }
}
