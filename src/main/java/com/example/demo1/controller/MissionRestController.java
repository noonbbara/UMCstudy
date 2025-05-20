package com.example.demo1.controller;

import com.example.demo1.apiPayload.ApiResponse;
import com.example.demo1.converter.MemberConverter;
import com.example.demo1.converter.MissionConverter;
import com.example.demo1.domain.Member;
import com.example.demo1.domain.Mission;
import com.example.demo1.dto.requestdto.MemberRequestDTO;
import com.example.demo1.dto.requestdto.MissionRequestDTO;
import com.example.demo1.dto.responsedto.MemberResponseDTO;
import com.example.demo1.dto.responsedto.MissionResponseDTO;
import com.example.demo1.service.MemberService.MemberCommandService;
import com.example.demo1.service.MissionService.MissionCommandService;
import com.example.demo1.service.MissionService.MissionQueryService;
import com.example.demo1.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping
    public ApiResponse<MissionResponseDTO.CreateResultDTO> create(@RequestBody @Valid MissionRequestDTO.CreateDTO request){
        Mission mission = missionCommandService.createRivew(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }


    @GetMapping("/{memberId}/challenging")
    @Operation(summary = "멤버가 도전 중인 미션 목록 조회 API",description = "도전 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getChallengingReviewList(@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") @ValidPage Integer page){
        Page<Mission> missionList = missionQueryService.getChallengingMissionList(memberId, page-1);
        return ApiResponse.onSuccess(MissionConverter.MissionPreViewListDTO(missionList));
    }
}