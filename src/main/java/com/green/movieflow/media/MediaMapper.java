package com.green.movieflow.media;

import com.green.movieflow.media.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MediaMapper {
    // 미디어 추가
    int insMedia(InsMediaDto dto);

    // 미디어 수정
    int putMedia(PutMedia dto);
    int delMediaPics(DelMediaDto dto);

    //미디어 추가, 수정
    int insMediaPics(InsMediaDto dto);


    List<MediaDaySelVo> getDayMedia(MediaDaySelDto dto);

    //-------------------------------------------------
    List<SelMediaVo> selMediaAll(MidiaAllSelDto dto);
    Integer selMediaByDelMedia(DelMediaDto dto);
    List<SelMediaAllVo> selMedia(SelMediaAllDto dto);
    SelMediaDetailVo selDetailMedia(SelMediaDto dto);
    List<String> selMediaPics(SelMediaDto dto);
    //미디어 삭제처리
    int delMedia(DelMediaDto dto);

}
