package com.green.movieflow.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "로그인 데이터")
public class UserSigninDto {
    @Schema(title = "아이디")
    private String uid;
    @Schema(title = "비밀번호")
    private String upw;
}
