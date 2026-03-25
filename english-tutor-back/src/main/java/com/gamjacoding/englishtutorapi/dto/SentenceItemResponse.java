package com.gamjacoding.englishtutorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SentenceItemResponse {
    private String englishText;
    private String koreanText;
    private String explanation;
}
