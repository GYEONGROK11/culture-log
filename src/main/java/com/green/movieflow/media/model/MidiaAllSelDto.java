package com.green.movieflow.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "메인 페이지 출력 데이터")
public class MidiaAllSelDto {
    @Schema(title = "년도")
    private String year;
    @JsonIgnore
    private int day;
    @Schema(title = "월")
    private String month;
    @Schema(title = "유저번호")
    private int iuser;
}
