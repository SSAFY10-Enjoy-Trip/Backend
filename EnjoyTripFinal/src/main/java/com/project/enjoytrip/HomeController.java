package com.project.enjoytrip;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// vue 작업 후 vite build 후 static 에 배포한 뒤에 refresh 할 때 White Label 페이지 처리
// error 발생 시에 /error 로 매핑되는 데 이 때 index.html 로 가도록 한다.
// index.html 이 처리되면서 vue-router 가 적용된다.
@Controller
public class HomeController implements ErrorController{
    @GetMapping("/error")
    public String redirectRoot() {
        return "index.html";
    }
}