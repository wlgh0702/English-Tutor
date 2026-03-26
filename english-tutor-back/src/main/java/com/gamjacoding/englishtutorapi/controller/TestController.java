package com.gamjacoding.englishtutorapi.controller;

import com.gamjacoding.englishtutorapi.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final OpenAiService openAiService;

    @GetMapping("/api/ai-test")
    public String aiTest() {
        return openAiService.generateSentenceJson("cafe", "BEGINNER");
    }
}
