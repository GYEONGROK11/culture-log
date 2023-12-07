package com.green.movieflow.media.model;

import lombok.Data;

import java.util.List;

@Data
public class InsMediaDto {
    private int iuser;
    private String title;
    private int genre;
    private String date;
    private int star;
    private String comment;
    private List<String> pics;
    private int isSaw;
}