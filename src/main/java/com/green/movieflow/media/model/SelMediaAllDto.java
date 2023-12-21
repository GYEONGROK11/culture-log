package com.green.movieflow.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "시청여부에 따른 미디어 출력 데이터 DTO")
public class SelMediaAllDto {
    @Schema(title = "유저 번호")
    private int iuser;
    @Schema(title = "시청여부")
    private int isSaw;
}
