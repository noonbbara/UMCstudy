package com.example.demo1.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResultDTO{
        Long id;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResultDTO{
        Long id;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDTO{
        Integer reward;
        LocalDate deadline;
        String missionSpec;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO{
        List<MissionPreViewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}