package com.green.movieflow.media.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "날짜별 데이터 출력 VO")
public class MediaDaySelVo {
    @Schema(title = "미디어 번호")
    private int imedia;
    @Schema(title = "제목")
    private String title;
    @Schema(title = "날짜")
    private String date;
    @Schema(title = "사진")
    private String pic;
    @Schema(title = "별점")
    private int star;
}
