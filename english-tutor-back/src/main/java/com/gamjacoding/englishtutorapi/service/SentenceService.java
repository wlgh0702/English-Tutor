package com.gamjacoding.englishtutorapi.service;

import com.gamjacoding.englishtutorapi.domain.Level;
import com.gamjacoding.englishtutorapi.dto.GenerateSentenceRequest;
import com.gamjacoding.englishtutorapi.dto.GenerateSentenceResponse;
import com.gamjacoding.englishtutorapi.dto.SentenceItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentenceService {

    public GenerateSentenceResponse generateSentences(GenerateSentenceRequest request) {
        String topic = request.getTopic();
        Level level = request.getLevel();

        List<SentenceItemResponse> sentences = List.of(
                new SentenceItemResponse(
                        "I'd like a cup of coffee.",
                        "커피 한 잔 주세요.",
                        topic + " 상황에서 자주 쓰는 표현"
                ),
                new SentenceItemResponse(
                        "Can I see the menu?",
                        "메뉴 좀 볼 수 있을까요?",
                        level + " 난이도 표현"
                )
        );

        return new GenerateSentenceResponse(sentences);
    }
}
