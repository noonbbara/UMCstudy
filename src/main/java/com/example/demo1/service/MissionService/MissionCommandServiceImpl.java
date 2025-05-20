package com.example.demo1.service.MissionService;

import com.example.demo1.converter.MissionConverter;
import com.example.demo1.domain.Mission;
import com.example.demo1.dto.requestdto.MissionRequestDTO;
import com.example.demo1.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;


    @Override
    public Mission createRivew(MissionRequestDTO.CreateDTO request) {
        Mission newMission = MissionConverter.toMission(request);

        return missionRepository.save(newMission);
    }
}