package com.green.movieflow.media.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Schema(title = "시청여부에 따른 미디어 출력 VO")
public class SelMediaAllVo {
    @Schema(title = "미디어 번호")
    private int imedia;
    @Schema(title = "제목")
    private String title;
    @Schema(title = "날짜")
    private String date;
    @Schema(title = "별점")
    private int star;
    @Schema(title = "사진")
    private String pic;


}