package com.green.movieflow.user;

import com.green.movieflow.common.Const;
import com.green.movieflow.common.ResVo;
import com.green.movieflow.user.model.UserSigninDto;
import com.green.movieflow.user.model.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    public ResVo postSignup(UserSignupDto dto){
        String hashPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        dto.setUpw(hashPw);

        if(dto.getUid().isBlank()){
            return null;
        }
        if(dto.getUpw().isBlank()){
            return null;
        }
        dto.getUpw().isBlank();
        int affectedRow = mapper.insSignup(dto);
        if(affectedRow == 0){
            return new ResVo(Const.FAIL);
        }
        return new ResVo(dto.getIuser());
    }

    public ResVo postSignin(UserSigninDto dto){
        String upw = mapper.selUserPw(dto);
        if(upw == null){
            return new ResVo(3); // 아이디 비번 불일치
        }
        Boolean comparedPw = BCrypt.checkpw(dto.getUpw(), upw);
        if(comparedPw){
            return new ResVo(1); // 아이디 비번 일치
        }
        return new ResVo(2); // 비번 불일치
    }
}
