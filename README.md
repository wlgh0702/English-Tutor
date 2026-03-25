# 📚 English Tutor

AI를 활용한 영어 학습 웹 애플리케이션입니다.  
사용자에게 자연스러운 영어 문장과 예문을 제공하고, 질문/답변 기능을 통해 영어 학습을 돕습니다.

---

## 🚀 프로젝트 소개

English Tutor는 정해진 시간마다 영어 문장을 제공하고,  
AI 기반으로 다양한 예문과 설명을 생성하여 사용자 학습을 돕는 서비스입니다.

- 일정 시간마다 영어 문장 제공
- AI 기반 예문 생성
- 영어 질문 & 답변 기능
- 사용자 친화적인 UI

---

## 🛠 기술 스택

### Backend
- Java
- Spring Boot
- JPA / MyBatis
- REST API

### Frontend
- Next.js
- TypeScript

### Database
- PostgreSQL / MySQL

### 기타
- OpenAI API
- Git / GitHub

---

## 📌 주요 기능

### 1. 영어 문장 제공
- 하루 4번 (12시, 15시, 18시, 21시) 영어 문장 제공

### 2. AI 예문 생성
- 입력된 문장을 기반으로 다양한 예문 생성

### 3. 질문 & 답변
- 사용자가 영어 관련 질문 입력
- AI가 자연스럽게 답변 제공

### 4. 게시판 기능
- 사용자 글 작성 및 조회 가능

---

## 📂 프로젝트 구조

```plaintext
English-Tutor
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   └── domain
│
├── frontend
│   ├── components
│   ├── pages
│   └── utils
```

---

## ⚙️ 실행 방법

### 1. 클론
```bash
git clone https://github.com/wlgh0702/English-Tutor.git
```

### 2. backend 실행
```bash
cd backend
./gradlew bootRun
```

### 3. frontend 실행
```bash
cd frontend
npm install
npm run dev
```

---

## 🔐 환경 변수 설정

`.env` 파일 생성 후 아래 내용 추가:

```env
OPENAI_API_KEY=your_api_key
DB_URL=your_db_url
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

---

## 🧠 배운 점

- 공통 기능 분리 및 재사용 구조 설계
- AI API 연동 경험
- 백엔드와 프론트 간 데이터 흐름 이해
- 유지보수 가능한 코드 구조 설계

---

## 📈 향후 개선 사항

- 카카오톡 알림 기능 추가
- 사용자 맞춤 학습 기능
- 영어 발음 기능 추가
- 모바일 UX 개선

---

## 👨‍💻 개발자

- GitHub: https://github.com/wlgh0702

---

## 📄 라이센스

This project is licensed under the MIT License.