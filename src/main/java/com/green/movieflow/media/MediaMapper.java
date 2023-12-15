package com.green.movieflow.media;

import com.green.movieflow.media.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MediaMapper {
    // 미디어 추가
    int insMedia(InsMediaDto dto);
    int insMediaPics(InsMediaDto dto);

    int patchIsSaw(MediaPatIsSawDto dto);

    int putMedia(PutMedia dto);

    int delMediaPics(DelMediaDto dto);

    List<MediaDaySelVo> getDayMedia(MediaDaySelDto dto);

    //-------------------------------------------------
    List<Integer> getMediaImedia(MidiaAllSelDto dto);
    List<SelMediaVo> selMediaAll(MidiaAllSelDto dto);
    List<SelMediaPicsProcVo> selMediapic(List<Integer> imediaList);
    Integer selMediaByDelMedia(DelMediaDto dto);
    int delMedia(DelMediaDto dto);
    List<SelMediaAllProcVo> selMedia(SelMediaAllDto dto);
    SelMediaDetailVo selDetailMedia(SelMediaDto dto);
    List<String> selMediaPics(SelMediaDto dto);
}
