package com.example.demo1.controller;

import com.example.demo1.apiPayload.ApiResponse;
import com.example.demo1.converter.MemberConverter;
import com.example.demo1.domain.Member;
import com.example.demo1.dto.requestdto.MemberRequestDTO;
import com.example.demo1.dto.responsedto.MemberResponseDTO;
import com.example.demo1.service.MemberService.MemberCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}