package com.DevVoca.backendServer.Service;

import com.DevVoca.backendServer.Model.LoginToken;
import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Repository.UserInfoRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;

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

        public UserInfo authUserInfo(LoginToken loginToken) throws Exception
        {
                System.out.println("토큰 : " + loginToken.getToken());
                System.out.println("email : " + loginToken.getEmail());
                System.out.println("name : " + loginToken.getName());
                System.out.println("authByToken execute");
                UserInfo result = null;
                GoogleIdToken token = verifier.verify(loginToken.getToken());
                if(token != null)       //token 인증에 성공할 경우(계정 정보가 올바른 사용자임을 확인함)
                {
                        GoogleIdToken.Payload payload = token.getPayload();     //결과 데이터
                        if(loginToken.getEmail().equals(payload.getEmail()) && loginToken.getName().equals(payload.get("name")))        //추가 인증(email, 이름 동일한지 확인함)
                        {
                                result = loginByToken(payload, loginToken.getToken());
                        }
                        else
                        {
                                System.out.println("인증 실패");
                        }
                }
                return result;
        }

        public UserInfo loginByToken(GoogleIdToken.Payload payload, String token)      //Token을 사용하여 로그인
        {
                System.out.println("loginByToken execute");
                UserInfo findUser = userInfoRepository.findByuserID(payload.getSubject());

                if(findUser==null)    //Token을 활용해서 찾았는데 ID가 없을 경우 -> 자동으로 회원가입 하도록 설정
                {
//                        findUser = userInfoRepository.save(new UserInfo(0,payload.getSubject(),payload.getEmail(), payload.get("name").toString(),null,null,1));
                }
                return findUser;
        }

        public UserInfo loginByLoginID(String loginID)
        {
                return userInfoRepository.findByuserID(loginID);
        }

        public UserInfo updateContinuous(UserInfo userinfo)     //연속 출석인지 검사
        {
                LocalDateTime lastLogin = userinfo.getLastLoginDate();
                LocalDateTime today = getTodayStartTime();

                long diffDays = Duration.between(lastLogin,today).toDays();
                if(diffDays==1) //연속 출석
                {

                }
                else if(diffDays > 1)   //연속 출석 실패
                {

                }
                else    //그외 예외상황
                {

                }
                /*
                * 1. UserInfo의 lastLogin 가져옴
                * 2. 오늘 날짜와 비교
                * 3. 오늘날짜와 하루차이라면? -> 연속 출석
                * 4. 하루 차이가 아니라면? -> 연속 출석이 아니게 됨
                * 5. 판단을 가지고 DB에 업데이트 후 반환
                * */
                //같은 날짜일 경우 Query 미실행은 app에서 판단, streak가 변경되야 할 경우 요청이 들어옴
                return userinfo;
        }

        public String testLogin(UserInfo userInfo)
        {
                UserInfo info = userInfoRepository.save(userInfo);
                LocalDateTime v1 = info.getLastLoginDate().toLocalDate().atStartOfDay();
                System.out.println("날짜 차이 : " + Duration.between(LocalDate.of(2023,5,5).atStartOfDay(),v1).toDays());
                ;
                return info.getUserName();
        }

        private LocalDateTime getTodayStartTime()
        {
                LocalDateTime dateTime = LocalDateTime.now();
                dateTime = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(),0,0);
                System.out.println(dateTime);
                return dateTime;
        }

        public UserInfo findById(int userNo)
        {
                Optional<UserInfo> userInfo = userInfoRepository.findById(userNo);
                if(userInfo.isPresent())
                {
                        return userInfo.get();
                }
                else return null;
        }

}
