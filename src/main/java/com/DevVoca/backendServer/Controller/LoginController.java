package com.DevVoca.backendServer.Controller;


import com.DevVoca.backendServer.Model.LoginToken;
import com.DevVoca.backendServer.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/auth")    //TODO api/auth로 넣어야함
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/google")
    String googleAuth(@RequestBody LoginToken loginToken)
    {
        return loginService.authIdToken(loginToken);
    }

}
