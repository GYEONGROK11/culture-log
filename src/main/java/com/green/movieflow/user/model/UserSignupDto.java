package com.green.movieflow.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "회원가입 데이터")
public class UserSignupDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "아이디")
    private String uid;
    @Schema(title = "비밀번호")
    private String upw;
    @Schema(title = "이름")
    private String nm;
}
