<script setup lang="ts">
import { ref } from 'vue';
import type { AxiosError } from 'axios';
import { generateSentences } from '../api/sentenceApi';

type SentenceItem = {
    englishText: string
    koreanText: string
    explanation: string
}

const topic = ref('');
const level = ref('BEGINNER');
const result = ref<SentenceItem[]>([]);
const errorMessage = ref('');

const generate = async () => {
    errorMessage.value = '';
    result.value = [];
    
    try {
        const data = await generateSentences(topic.value, level.value);
        result.value = data.sentences;
    } catch (error) {
        console.error('Error generating sentences:', error);
        const axiosError = error as AxiosError<{ message?: string }>;
        errorMessage.value =
            axiosError.response?.data?.message ||
            '예문 생성에 실패했습니다. 다시 시도해주세요.';
    }
}
</script>

<template>
    <div class="page">
        <h1>AI 영어 학습 홈</h1>

        <div class="controls">
            <input
                v-model="topic"
                class="pink-input"
                type="text"
                placeholder="주제를 입력하세요"
            />

            <div class="select-wrap">
                <select v-model="level" class="pink-select">
                    <option value="BEGINNER">초급</option>
                    <option value="INTERMEDIATE">중급</option>
                    <option value="ADVANCED">고급</option>
                </select>
            </div>

            <button class="pink-button" @click="generate">생성</button>
            
            <p v-if="errorMessage">{{ errorMessage }}</p>

            <div v-if="result.length > 0">

                <h2 class="result-title">생성 결과</h2>
                <p class="result-sub">
                    선택한 레벨 기준으로 예문/해석/설명을 정리했어요.
                </p>

                <div class="result-list">
                    <div
                        v-for="item in result"
                        :key="item.englishText"
                        class="sentence-card"
                    >
                        <div class="sentence-block">
                            <div class="lang-label">영문</div>
                            <div class="english-text">{{ item.englishText }}</div>
                        </div>

                        <div class="sentence-block">
                            <div class="lang-label">해석</div>
                            <div class="korean-text">{{ item.koreanText }}</div>
                        </div>

                        <div class="sentence-block">
                            <div class="lang-label">설명</div>
                            <div class="explain-text">{{ item.explanation }}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
.page {
    width: 80vw;
    max-width: 560px;
    margin: 44px auto;
    padding: 26px 22px;
    border-radius: 18px;
    background: linear-gradient(135deg, #fff2f7 0%, #ffe6f0 45%, #fff7fb 100%);
    border: 1px solid rgba(255, 95, 162, 0.22);
    box-shadow:
        0 14px 40px rgba(255, 95, 162, 0.12),
        0 2px 10px rgba(0, 0, 0, 0.04);
}

.page h1 {
    margin: 0 0 18px;
    font-size: 24px;
    color: #c2185b;
    letter-spacing: -0.3px;
}

.controls {
    display: flex;
    flex-direction: column;
    align-items: stretch;
    gap: 14px;
}

.pink-input,
.pink-select {
    display: block;
    width: 100%;
    box-sizing: border-box;
    height: 46px;
    border-radius: 14px;
    border: 1px solid #f3b6c9;
    background: rgba(255, 255, 255, 0.75);
    color: #4a2030;
    padding: 0 16px;
    font-size: 15px;
    outline: none;
    transition:
        box-shadow 160ms ease,
        border-color 160ms ease,
        background 160ms ease,
        transform 160ms ease;
}

.pink-input::placeholder {
    color: rgba(76, 34, 57, 0.55);
}

.pink-input:focus,
.pink-select:focus {
    border-color: #ff5fa2;
    background: rgba(255, 255, 255, 0.95);
    box-shadow: 0 0 0 5px rgba(255, 95, 162, 0.18);
}

.select-wrap {
    position: relative;
    width: 100%;
}

.pink-select {
    appearance: none;
    padding-right: 44px;
    background-image:
        linear-gradient(45deg, transparent 50%, #ff5fa2 50%),
        linear-gradient(135deg, #ff5fa2 50%, transparent 50%);
    background-position:
        calc(100% - 22px) 18px,
        calc(100% - 16px) 18px;
    background-size: 6px 6px, 6px 6px;
    background-repeat: no-repeat;
}

/* 브라우저별로 option 스타일이 제한적일 수 있어, 기본 색/배경 정도만 지정합니다. */
.pink-select option {
    background: white;
    color: #4a2030;
}

.pink-button {
    height: 46px;
    border-radius: 14px;
    border: none;
    cursor: pointer;
    color: #ffffff;
    font-weight: 800;
    font-size: 15px;
    background: linear-gradient(135deg, #ff5fa2 0%, #ff86c3 100%);
    box-shadow:
        0 12px 26px rgba(255, 95, 162, 0.28),
        0 2px 10px rgba(0, 0, 0, 0.06);
    transition:
        transform 150ms ease,
        box-shadow 150ms ease,
        filter 150ms ease;
}

.pink-button:hover {
    transform: translateY(-1px);
    box-shadow:
        0 16px 34px rgba(255, 95, 162, 0.33),
        0 2px 10px rgba(0, 0, 0, 0.07);
    filter: saturate(1.03);
}

.pink-button:active {
    transform: translateY(0px);
}

.result-title {
    margin: 8px 0 6px;
    font-size: 18px;
    color: #8e1b4f;
    letter-spacing: -0.2px;
}

.result-sub {
    margin: 0 0 14px;
    font-size: 13px;
    color: rgba(76, 34, 57, 0.7);
    line-height: 1.5;
}

.result-list {
    display: flex;
    flex-direction: column;
    gap: 12px;
}

.sentence-card {
    border-radius: 16px;
    padding: 14px 14px;
    background:
        linear-gradient(135deg, rgba(255, 255, 255, 0.75) 0%, rgba(255, 235, 245, 0.85) 100%);
    border: 1px solid rgba(255, 95, 162, 0.18);
    box-shadow:
        0 10px 26px rgba(255, 95, 162, 0.08),
        0 1px 8px rgba(0, 0, 0, 0.03);
}

.sentence-block + .sentence-block {
    margin-top: 10px;
    padding-top: 10px;
    border-top: 1px dashed rgba(255, 95, 162, 0.18);
}

.lang-label {
    display: inline-block;
    font-size: 12px;
    font-weight: 800;
    color: #c2185b;
    margin-bottom: 6px;
}

.english-text {
    font-size: 14px;
    color: #3a1728;
    font-weight: 700;
    line-height: 1.6;
    word-break: keep-all;
}

.korean-text {
    font-size: 14px;
    color: #5b2040;
    line-height: 1.6;
}

.explain-text {
    font-size: 13px;
    color: rgba(76, 34, 57, 0.85);
    line-height: 1.55;
}
</style>