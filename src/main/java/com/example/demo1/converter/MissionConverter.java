package com.example.demo1.converter;

import com.example.demo1.domain.Mission;
import com.example.demo1.dto.requestdto.MissionRequestDTO;
import com.example.demo1.dto.responsedto.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission){
        return MissionResponseDTO.CreateResultDTO.builder()
                .id(mission.getId())
                .build();
    }


    public static Mission toMission(MissionRequestDTO.CreateDTO request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO MissionPreViewListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

}