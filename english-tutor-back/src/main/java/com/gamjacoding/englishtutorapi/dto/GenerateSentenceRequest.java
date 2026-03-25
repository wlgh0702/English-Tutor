package com.gamjacoding.englishtutorapi.dto;

import com.gamjacoding.englishtutorapi.domain.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateSentenceRequest {

    @NotBlank(message = "주제는 필수값입니다.")
    private String topic;

    @NotNull(message = "레벨은 필수값입니다.")
    private Level level;
}
