package com.gamjacoding.englishtutorapi.controller;

import com.gamjacoding.englishtutorapi.dto.GenerateSentenceRequest;
import com.gamjacoding.englishtutorapi.dto.GenerateSentenceResponse;
import com.gamjacoding.englishtutorapi.dto.SentenceItemResponse;
import com.gamjacoding.englishtutorapi.service.SentenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SentenceController {

    private final SentenceService sentenceService;

    @PostMapping("/generateSentences")
    public GenerateSentenceResponse generateSentences(@Valid @RequestBody GenerateSentenceRequest request) {
        return sentenceService.generateSentences(request);
    }
}
