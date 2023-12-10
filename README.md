# Backend
Spring Boot 개발 내용


### Email
 : auth/controller/EmailController.java

|Link|API|Return|Method|Description|
|:---:|:---:|:-----:|:---:|:---:|
|/check/{email}|Get|Map<String, String>|registerEmailCheck|회원가입을 위한 Email 존재여부 확인|
|/check/findPassword|Post|Map<String, String>|findPassword|비밀번호 찾기를 위한 Email 존재여부 확인|

<br>

### Login
 : auth/controller/LoginController.java

|Link|API|Return|Method|Description|
|:---:|:---:|:-----:|:---:|:---:|
|/login|Post|Map<String, String>|Login|사용자의 로그인 행위|
|/logout|Get|Map<String, String>|findPassword|사용자의 로그아웃 행위|
|/checkSession|Get|Map<String, String>|findPassword|사용자의 세션 존재 여부 확인 존재 시 회원정보(memberId, email, name, porfileImageUrl, role) 반환|

