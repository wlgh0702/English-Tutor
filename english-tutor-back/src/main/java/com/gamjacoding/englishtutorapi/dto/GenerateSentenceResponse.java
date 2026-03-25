package com.gamjacoding.englishtutorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GenerateSentenceResponse {
    private List<SentenceItemResponse> sentences;
}
