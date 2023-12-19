package com.green.movieflow.media.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SelMediaDto {
    @Schema(title = "미디어 번호 ")
    private int imedia;
    @Schema(title = "유저 번호 ")
    private int iuser;
}
