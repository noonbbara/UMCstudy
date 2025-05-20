package com.example.demo1.service.MissionService;

import com.example.demo1.domain.Mission;
import com.example.demo1.dto.requestdto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createRivew(MissionRequestDTO.CreateDTO request);
}