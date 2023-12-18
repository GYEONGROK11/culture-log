package com.green.movieflow.media;

import com.green.movieflow.common.Const;
import com.green.movieflow.common.ResVo;
import com.green.movieflow.media.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MediaService {
    private final MediaMapper mapper;
    // 미디어 추가
    public ResVo postMedia(InsMediaDto dto){
        mapper.insMedia(dto);
        mapper.insMediaPics(dto);
        return new ResVo(dto.getImedia());
    }
    public ResVo putMedia(PutMedia dto){
        mapper.putMedia(dto);
        if (dto.getPics().size() >= Const.PIC_SIZE_MIN
                && dto.getPics().size() <= Const.PIC_SIZE_MAX){
            DelMediaDto dto1 = new DelMediaDto();
            dto1.setImedia(dto.getImedia());
            mapper.delMediaPics(dto1);
            InsMediaDto dto2 = new InsMediaDto();
            dto2.setImedia(dto.getImedia());
            dto2.setPics(dto.getPics());
            mapper.insMediaPics(dto2);
        }
        return new ResVo(Const.SUCCESS);
    }

    public List<MediaDaySelVo> getDayMedia(MediaDaySelDto dto){
        return mapper.getDayMedia(dto);
    }


    //-----------------------------------------------------

    // 메인페이지
    public List<SelMediaVo> getMediaAll(MidiaAllSelDto dto){
        return mapper.selMediaAll(dto);
    }

    // 마이페이지
    public List<SelMediaAllVo> getMedia(SelMediaAllDto dto){
        List<SelMediaAllVo> list = mapper.selMedia(dto);
        return list;
    }

    // 상세페이지
    public SelMediaDetailVo getDetailMedia(SelMediaDto dto){
        SelMediaDetailVo vo = mapper.selDetailMedia(dto);
        List<String> pics = mapper.selMediaPics(dto);
        vo.setPics(pics);
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
        mapper.delMedia(dto);
        return new ResVo(Const.SUCCESS);
    }
}
