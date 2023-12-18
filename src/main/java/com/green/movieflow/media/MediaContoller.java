package com.green.movieflow.media;

import com.green.movieflow.common.ResVo;
import com.green.movieflow.media.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/media")
@Tag(name = "미디어 API",description = "미디어 관련 처리")
public class MediaContoller {
    private final MediaService service;

    // 미디어 등록
    @PostMapping
    @Operation(summary = "미디어 등록",description = "미디어 등록")
    public ResVo postMedia(@RequestBody InsMediaDto dto){
        return service.postMedia(dto);
    }

    // 미디어 수정
    @PutMapping
    @Operation(summary = "미디어 수정",description = "미디어 수정")
    public ResVo putMedia(@RequestBody PutMedia dto){
        return service.putMedia(dto);
    }

    // iuser, date
    @GetMapping("/day")
    @Operation(summary = "날짜별 미디어 리스트",description = "날짜별 미디어 리스트")
    public List<MediaDaySelVo> getDayMedia(int iuser, String date){
        return service.getDayMedia(MediaDaySelDto.builder()
                        .iuser(iuser)
                        .date(date)
                        .build());
    }

    // issaw, imedia, iuser
    @PatchMapping
    @Operation(summary = "시청여부 수정",description = "시청여부 수정")
    public ResVo patchIsSaw(MediaPatIsSawDto dto){
        return service.patchIsSaw(dto);
    }

    //----------------------------------------------------------

    // 메인페이지
    @GetMapping("/ym")
    @Operation(summary = "메인페이지",description = "메인페이지")
    public List<SelMediaVo> getMediaAll(MidiaAllSelDto dto){
        return service.getMediaAll(dto);
    }

    // 마이페이지
    @GetMapping
    @Operation(summary = "마이페이지",description = "마이페이지")
    public List<SelMediaAllVo> getMedia(@RequestParam("is_saw")int isSaw, int iuser){
        SelMediaAllDto dto = new SelMediaAllDto();
        dto.setIsSaw(isSaw);
        dto.setIuser(iuser);
        return service.getMedia(dto);
    }

    // 상세페이지
    @GetMapping("/{imedia}")
    @Operation(summary = "상세페이지",description = "상세페이지")
    public SelMediaDetailVo getDetailMedia(@PathVariable int imedia, int iuser){
        return service.getDetailMedia(SelMediaDto.builder()
                .imedia(imedia)
                .iuser(iuser)
                .build());
    }

    // 미디어삭제
    @DeleteMapping
    @Operation(summary = "미디어삭제",description = "미디어삭제")
    public ResVo delMedia(DelMediaDto dto){
        return service.delMedia(dto);
    }
}
