package com.green.movieflow.media.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "미디어 삭제 데이터 DTO")
public class DelMediaDto {
    @Schema(title = "유저번호")
    private int iuser;
    @Schema(title = "미디어번호")
    private int imedia;
}
