package com.green.movieflow.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "미디어 등록 데이터")
public class InsMediaDto {
    @JsonIgnore
    private int imedia;
    @Schema(title = "유저번호")
    private int iuser;
    @Schema(title = "장르번호")
    private int genrepk;
    @Schema(title = "제목")
    private String title;
    @Schema(title = "시청 날짜")
    private String date;
    @Schema(title = "감상평")
    private String comment;
    @Schema(title = "별점")
    private int star;
    @Schema(title = "시청여부")
    private int isSaw;
    @Schema(title = "미디어 사진 리스트")
    private List<String> pics;
}
