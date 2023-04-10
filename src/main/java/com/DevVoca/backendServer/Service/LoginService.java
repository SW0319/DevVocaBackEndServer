package com.DevVoca.backendServer.Service;

import com.DevVoca.backendServer.Model.LoginToken;
import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Repository.UserInfoRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonToken;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginService
{
        @Autowired
        UserInfoRepository userInfoRepository;
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new GsonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport,jsonFactory)
                .setAudience(Collections.singletonList("26426668169-qa1kmh47s0bs9f1l8aoi14lktdqhrd8m.apps.googleusercontent.com"))
                .build();

        public String authIdToken(LoginToken loginToken)
        {
                System.out.println("토큰 : " + loginToken.getToken());
                System.out.println("email : " + loginToken.getEmail());
                System.out.println("name : " + loginToken.getName());
                System.out.println("authByToken execute");
                String result = "fail";
                try{
                        System.out.println("try execute");
                GoogleIdToken token = verifier.verify(loginToken.getToken());
                if(token != null)       //token 인증에 성공할 경우(계정 정보가 올바른 사용자임을 확인함)
                {
                        GoogleIdToken.Payload payload = token.getPayload();
                        result = loginByToken(payload);
                }
                }catch (Exception e)
                {
                        e.printStackTrace();
                        return null;
                }
                return result;
        }

        public String loginByToken(GoogleIdToken.Payload payload)      //Token을 사용하여 로그인
        {
                System.out.println("loginByToken execute");
                int findUser = userInfoRepository.findByuserID(payload.getSubject());
                String result = "fail";

                if(findUser==0)    //Token을 활용해서 찾았는데 ID가 없을 경우 -> 자동으로 회원가입 하도록 설정
                {
                        userInfoRepository.save(new UserInfo(payload.getSubject(),payload.getEmail(), payload.get("name").toString()));
                        result = payload.getEmail();
                }
                else if(findUser==1)
                {
                        System.out.println("이미 있음!");
                }
                else if(findUser>1)
                {
                        System.out.println("발생 X");
                }
                return result;
        }

}
