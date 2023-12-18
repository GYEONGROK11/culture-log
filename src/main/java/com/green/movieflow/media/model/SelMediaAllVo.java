package com.green.movieflow.media.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class SelMediaAllVo {
    private int imedia;
    private String title;
    private String date;
    private String pic;
    private int star;

}