# 📂 프로젝트 구조

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

# ⚙️ 실행 방법

## 1. 클론
```bash
git clone https://github.com/wlgh0702/English-Tutor.git
```

## 2. backend 실행
```bash
cd backend
./gradlew bootRun
```

## 3. frontend 실행
```bash
cd frontend
npm install
npm run dev
```

---

# 🔐 환경 변수 설정

`.env` 파일 생성 후 아래 내용 추가:

```env
OPENAI_API_KEY=your_api_key
DB_URL=your_db_url
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

---

# 🧠 배운 점

- 공통 기능 분리 및 재사용 구조 설계
- AI API 연동 경험
- 백엔드와 프론트 간 데이터 흐름 이해
- 유지보수 가능한 코드 구조 설계

---

# 📈 향후 개선 사항

- 카카오톡 알림 기능 추가
- 사용자 맞춤 학습 기능
- 영어 발음 기능 추가
- 모바일 UX 개선

---

# 👨‍💻 개발자

- GitHub: https://github.com/wlgh0702

---

# 📄 라이센스

This project is licensed under the MIT License.