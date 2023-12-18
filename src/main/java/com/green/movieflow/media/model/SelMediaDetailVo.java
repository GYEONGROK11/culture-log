package com.green.movieflow.media.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "상세페이지 출력 데이터")

public class SelMediaDetailVo {
    @Schema(title = "미디어 번호")
    private int imedia;
    @Schema(title = "제목")
    private String title;
    @Schema(title = "감상평")
    private String comment;
    @Schema(title = "날짜")
    private String date;
    @Schema(title = "시청여부")
    private int isSaw;
    @Schema(title = "장르 번호")
    private int genrePk;
    @Schema(title = "별점")
    private int star;
    @Schema(title = "사진리스트")
    private List<String> pics;
}
