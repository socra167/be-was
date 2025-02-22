# java-was-2023

Java Web Application Server 2023

---

## 구현 내용
### [Step-1] index.html 응답
- [x] 정적 파일 응답
- [x] HTTP Request 내용 Logger 출력
- [x] Thread기반 프로젝트를 Concurrent 패키지를 사용하도록 변경

### [Step-2] GET으로 회원가입
- [x] "회원가입" 메뉴를 클릭하면 회원가입 폼을 표시한다 
- [x] 회원가입 폼으로 회원가입을 할 수 있다
- [x] 가입 버튼을 클릭하면 사용자 입력 값이 서버에 전달된다
- [x] HTML과 URL을 비교해 보고 사용자가 입력한 값을 파싱해 model.User 클래스에 저장한다
- [x] SoftAssertion으로 회원가입 컨트롤러 테스트
- [x] 회원가입 성공 시 메인 페이지로 리다이렉트

### [Step-3] 다양한 컨텐츠타입 지원
- [x] html, css, js, ico, png, jpg 타입을 지원한다

### [Step-4] POST로 회원가입
- [x] 로그인을 GET에서 POST로 동작하도록 변경한다
- [x] 가입을 완료하면 /index.html 페이지로 이동한다

### [Step-5] 쿠키를 이용한 로그인
- [x] 가입한 회원 정보로 로그인을 할 수 있다
- [x] [로그인] 메뉴를 클릭하면 http://localhost:8080/user/login.html 으로 이동해 로그인할 수 있다
- [x] 로그인이 성공하면 index.html로 이동한다
- [x] 로그인이 실패하면 /user/login_failed.html로 이동한다

### [Step-6] 동적인 HTML

- [x] 사용자가 로그인 상태일 경우 /index.html에서 사용자 이름을 표시해 준다.
- [x] 사용자가 로그인 상태가 아닐 경우 /index.html에서 [로그인] 버튼을 표시해 준다.
- [x] 사용자가 로그인 상태일 경우 http://localhost:8080/user/list 에서 사용자 목록을 출력한다.
- [x] http://localhost:8080/user/list 페이지 접근시 로그인하지 않은 상태일 경우 로그인 페이지(login.html)로 이동한다.

### [Step-7] 게시판 기능 완성

**글쓰기 기능**

- [x] index.html 하단에 글쓰기 버튼을 추가한다
- [x] 로그인한 사용자가 글쓰기 버튼을 클릭 시 write.html로 이동한다
- [x] 로그인하지 않은 사용자가 글쓰기 버튼을 클릭 시 로그인 페이지로 이동한다
- [x] write.html에서 글의 본문을 입력할 수 있는 폼을 표시한다
- [x] 작성한 글의 제목을 index.html에서 보여준다

**세부 글 표시 기능**

- [x] 로그인한 사용자가 글 제목 클릭 시 세부 내용을 볼 수 있는 페이지로 이동한다
- [x] 로그인하지 않은 사용자가 글 제목 클릭 시 로그인 페이지로 이동한다

**404 및 에러 처리 페이지**

- [x] 존재하지 않는 URL 요청이 404 페이지로 이동한다

## 프로젝트 정보

이 프로젝트는 우아한 테크코스 박재성님의 허가를 받아 https://github.com/woowacourse/jwp-was
를 참고하여 작성되었습니다.
