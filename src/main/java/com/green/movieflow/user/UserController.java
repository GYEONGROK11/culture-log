package com.green.movieflow.user;

import com.green.movieflow.common.ResVo;
import com.green.movieflow.user.model.UserSigninDto;
import com.green.movieflow.user.model.UserSignupDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "유저 API",description = "유저 관련 처리")
public class UserController {
    private final UserService service;

    // 회원가입
    @PostMapping("/signup")
    @Operation(summary = "회원가입",description = "회원가입 처리")
    public ResVo postSignup(@RequestBody UserSignupDto dto){
        return service.postSignup(dto);
    }

    // 로그인
    @PostMapping("/signin")
    @Operation(summary = "로그인",description = "로그인 처리")
    public ResVo postSignin(@RequestBody UserSigninDto dto){
        return service.postSignin(dto);
    }
}
