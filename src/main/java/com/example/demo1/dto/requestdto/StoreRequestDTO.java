package com.example.demo1.dto.requestdto;

import com.example.demo1.domain.Region;
import com.example.demo1.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class StoreAddRequestDTO{
        @NotNull
        private String name;
        @NotNull
        private String address;
        @NotNull
        private Region region;
    }
}
