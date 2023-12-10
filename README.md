# Backend

## 환경구성

개인정보 보호를 위해 ```application.properties``` 파일을 올리지 않았습니다. <br>
아래 내용을 ```src\main\resources```에 위치시켜 주시기 바랍니다.
``` yaml
#datasource
spring.datasource.url=jdbc:mysql://localhost:3306/enjoytripfinal?serverTimezone=Asia/Seoul
spring.datasource.username={ DB접속 이름 }
spring.datasource.password={ DB접속 비밀번호 }
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

server.servlet.encoding.force-response=true

#JPA
#show SQL
spring.jpa.show-sql=true
# show Hibernate SQL
spring.jpa.properties.hibernate.format.sql=true

# Find Password Email Setting
# fill username & password
spring.mail.host=smtp.naver.com
spring.mail.port=465
spring.mail.username={ 네이버 email }
spring.mail.password={ 네이버 비밀번호 }
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.ssl.enable=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.naver.com
spring.mail.properties.mail.smtp.starttls.enable=true
```
<br><br>

## API List
: 사용된 API에 대해 정리합니다. 명시되지 않은 ```Map<String, String>```는 <br> 기본적으로 ```{"result": "success"}``` 혹은 ```{"result": "fail"}```로 해당 행위의 성공 여부를 알립니다.

### Email
 : auth/controller/EmailController.java

|Link|API|Return|Method|Description|
|:---:|:---:|:-----:|:---:|:---|
|/check/{email}|Get|Map<String, String>|registerEmailCheck|회원가입을 위한 Email 존재여부 확인|
|/check/findPassword|Post|Map<String, String>|findPassword|비밀번호 찾기를 위한 Email 존재여부 확인|

<br>

### Login
 : auth/controller/LoginController.java

|Link|API|Return|Method|Description|
|:---:|:---:|:-----:|:---:|:---|
|/login|Post|Map<String, String>|Login|사용자의 로그인 행위|
|/logout|Get|Map<String, String>|findPassword|사용자의 로그아웃 행위|
|/checkSession|Get|Map<String, String>|findPassword|사용자의 세션 존재 여부 확인 존재 시 회원정보(memberId, email, name, porfileImageUrl, role) 반환|

