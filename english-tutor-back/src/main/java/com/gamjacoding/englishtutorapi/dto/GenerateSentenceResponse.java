package com.gamjacoding.englishtutorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GenerateSentenceResponse {
    private List<SentenceItemResponse> sentences;
}
