package com.green.movieflow.user;

import com.green.movieflow.user.model.UserSigninDto;
import com.green.movieflow.user.model.UserSignupDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insSignup(UserSignupDto dto);
    UserSigninDto selUserPw(UserSigninDto dto);
}
