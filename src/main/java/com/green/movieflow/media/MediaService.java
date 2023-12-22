package com.green.movieflow.media;

import com.green.movieflow.common.Const;
import com.green.movieflow.common.ResVo;
import com.green.movieflow.media.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MediaService {
    private final MediaMapper mapper;
    // 미디어 추가
    public ResVo postMedia(InsMediaDto dto){

        boolean date_check = Pattern.matches("([12]\\d{3})-(0[1-9]|1[012])-(0[0-9]|[12][0-9]|3[01])",dto.getDate());
        for (int i = 0; i < dto.getPics().size(); i++) {
            boolean pic_check = Pattern.matches("https://+.*",dto.getPics().get(i));
            if(pic_check ==false){
                return new ResVo(Const.PIC_PATTERN_MISS);
            }
        }

        if(!StringUtils.hasLength(dto.getTitle())
                || dto.getIuser() < 0
                || (dto.getIsSaw() < Const.ISSEE
                && dto.getIsSaw() > Const.ISSAW)
                || (dto.getPics().size() < Const.PIC_SIZE_MIN
                && dto.getPics().size() > Const.PIC_SIZE_MAX)
                || (dto.getGenrePk() < Const.GENRE_MIN
                && dto.getGenrePk() > Const.GENRE_MAX)
                || !StringUtils.hasLength(dto.getDate())
                ||date_check == false) {
            return new ResVo(Const.FAIL);
        }
        try {
            int affectedRows = mapper.insMedia(dto);
            log.info("affectedRows : {}",affectedRows);
        } catch (Exception e){
            e.printStackTrace();
            return new ResVo(Const.FAIL);
        }
        try {
            int affectedPicRows = mapper.insMediaPics(dto);
            log.info("affectedRows : {}", affectedPicRows);
        } catch (Exception e){
            e.printStackTrace();
            return new ResVo(Const.FAIL);
        }

        return new ResVo(dto.getImedia());
    }
    public ResVo putMedia(PutMedia dto){

        boolean date_check = Pattern.matches("([12]\\d{3})-(0[1-9]|1[012])-(0[0-9]|[12][0-9]|3[01])",dto.getDate());
        for (int i = 0; i < dto.getPics().size(); i++) {
            boolean pic_check = Pattern.matches("https://+.*",dto.getPics().get(i));
            if(pic_check == false){
                return new ResVo(Const.PIC_PATTERN_MISS);
            }
        }
        if(!StringUtils.hasLength(dto.getTitle())//공백 체크, null체크 를 합친 메소드 : StringUtils.hasLength(dto.getTitle()값이 잘 들어올 경우 true
                || dto.getImedia() < 0
                || dto.getIuser() < 0
                || (dto.getIsSaw() < Const.ISSEE
                && dto.getIsSaw() > Const.ISSAW)
                || (dto.getGenrePk() < Const.GENRE_MIN
                && dto.getGenrePk() > Const.GENRE_MAX)
                || !StringUtils.hasLength(dto.getDate())
                ||date_check == false) {
            return new ResVo(Const.FAIL);
        }
        int affectedRows = mapper.putMedia(dto);
        if(affectedRows ==0){
            return new ResVo(Const.FAIL);
        }


            if (dto.getPics().size() >= Const.PIC_SIZE_MIN
                    && dto.getPics().size() <= Const.PIC_SIZE_MAX){
                DelMediaDto dto1 = new DelMediaDto();
                dto1.setImedia(dto.getImedia());
                int affectedDelRows = mapper.delMediaPics(dto1);
                InsMediaDto dto2 = new InsMediaDto();
                dto2.setImedia(dto.getImedia());
                dto2.setPics(dto.getPics());
                int affectedPicRows = mapper.insMediaPics(dto2);

                if(affectedDelRows == 0){
                    return new ResVo(Const.FAIL);
                }
            }

        return new ResVo(Const.SUCCESS);
    }

    public List<MediaDaySelVo> getDayMedia(MediaDaySelDto dto){

        List<MediaDaySelVo> list;
        try {
            list = mapper.getDayMedia(dto);
            log.info("list : {}", list);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return list;
    }


    //-----------------------------------------------------

    // 메인페이지
    public List<SelMediaVo> getMediaAll(MidiaAllSelDto dto){
        List<SelMediaVo> list;

        try {
            list = mapper.selMediaAll(dto);
            log.info("list : {}", list);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return list;
    }

    // 마이페이지
    public List<SelMediaAllVo> getMedia(SelMediaAllDto dto){
        List<SelMediaAllVo> list;

        try {
            list = mapper.selMedia(dto);
            log.info("list : {}", list);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return list;
    }

    // 상세페이지
    public SelMediaDetailVo getDetailMedia(SelMediaDto dto){
        SelMediaDetailVo vo;

        try {
            vo =  mapper.selDetailMedia(dto);
            log.info("list : {}", vo);
            if(vo == null){
                return null;
            }
            List<String> pics = mapper.selMediaPics(dto);
            vo.setPics(pics);

            if(vo.getPics().size() < Const.PIC_SIZE_MIN
                    && vo.getPics().size() > Const.PIC_SIZE_MAX){
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return vo;
    }

    // media 삭제
    public ResVo delMedia(DelMediaDto dto){
        // 셀렉트로 있는지 확인 먼저
        Integer imedia = mapper.selMediaByDelMedia(dto);
        if(imedia == null){
            return new ResVo(Const.FAIL);
            // 없으면 리턴
        }

        int affectedDelRows = mapper.delMedia(dto);

        return new ResVo(Const.SUCCESS);
    }
}
