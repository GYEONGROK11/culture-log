package com.green.movieflow.media.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Schema(title = "날짜별 데이터 DTO")
public class MediaDaySelDto {
    @Schema(title = "미디어 번호")
    private int iuser;
    @Schema(title = "날짜")
    private String date;
}
