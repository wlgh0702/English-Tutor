package com.gamjacoding.englishtutorapi.service;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final RestTemplate restTemplate;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String generateSentenceJson(String topic, String level) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        String prompt = """
                You are an English tutor for Korean learners.
                
                The user wants to learn English expressions used in real-life situations.
                
                Topic: %s
                Level: %s
                
                Create 2 natural English sentences that someone would actually say in this situation.
                
                IMPORTANT:
                - The sentences must be used in real-life conversation
                - Do NOT explain the topic itself
                - Do NOT describe the place or concept
                - Focus on what people would SAY
                
                Return ONLY valid JSON.
                
                Use this exact format:
                {
                    "sentences": [
                        {
                            "englishText": "...",
                            "koreanText": "...",
                            "explanation": "..."
                        }
                    ]
                }
                """.formatted(topic, level);

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-5.4",
                "input", prompt
        );

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        return extractOutputText(response.getBody());
    }

    private String extractOutputText(Map responseBody) {
        List<Map<String, Object>> output = (List<Map<String, Object>>) responseBody.get("output");

        if(output == null || output.isEmpty()) {
            throw new RuntimeException("No output found");
        }

        for(Map<String, Object> item : output) {
            Object contentObj = item.get("content");
            if(contentObj instanceof List<?> contentList) {
                for(Object contentItemObj : contentList) {
                    if(contentItemObj instanceof Map<?, ?> contentItem) {
                        Object type = contentItem.get("type");
                        Object text = contentItem.get("text");

                        if("output_text".equals(type) && text instanceof String) {
                            return text.toString();
                        }
                    }
                }
            }
        }

        throw new RuntimeException("No output_text found in OpenAi response");
    }
}
