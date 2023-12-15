package com.green.movieflow.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SelMediaVo {
    @Schema(title = "미디어 번호 리스트")
    private List<Integer> imedia;
    @Schema(title = "일자")
    private int day;
    @JsonIgnore
    private List<String> pics = new ArrayList<>();
    @Schema(title = "미디어 사진")
    private String pic;
}
