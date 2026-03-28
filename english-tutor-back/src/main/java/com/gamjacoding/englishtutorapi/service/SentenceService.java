package com.gamjacoding.englishtutorapi.service;

import com.gamjacoding.englishtutorapi.domain.Level;
import com.gamjacoding.englishtutorapi.dto.GenerateSentenceRequest;
import com.gamjacoding.englishtutorapi.dto.GenerateSentenceResponse;
import com.gamjacoding.englishtutorapi.dto.SentenceItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SentenceService {

    private final OpenAiService openAiService;
    private final ObjectMapper objectMapper;

    public GenerateSentenceResponse generateSentences(GenerateSentenceRequest request) {
        try {
            String aiJson = openAiService.generateSentenceJson(
                    request.getTopic(), request.getLevel().name()
            );

            return objectMapper.readValue(aiJson, GenerateSentenceResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate sentences", e);
        }
    }
}
