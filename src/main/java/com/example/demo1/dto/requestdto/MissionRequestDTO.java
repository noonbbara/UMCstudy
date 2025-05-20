package com.example.demo1.dto.requestdto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class CreateDTO{
        Integer reward;
        LocalDate deadline;

        @Size(min = 5, max = 100)
        String missionSpec;
    }
}