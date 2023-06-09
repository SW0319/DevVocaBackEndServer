package com.DevVoca.backendServer.Controller;


import com.DevVoca.backendServer.Model.LoginToken;
import com.DevVoca.backendServer.Model.UserInfo;
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
    UserInfo googleAuth(@RequestBody LoginToken loginToken) throws Exception  //이러면 예외처리는 누가 하게 되는건가?
    {
        return loginService.authUserInfo(loginToken);
    }

    @PostMapping("/google/login")
    UserInfo googleLogin(@RequestBody String userID) throws Exception
    {
        return loginService.loginByLoginID(userID);
    }

}
