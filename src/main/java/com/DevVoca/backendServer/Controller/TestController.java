package com.DevVoca.backendServer.Controller;

import com.DevVoca.backendServer.Model.VocaList;
import com.DevVoca.backendServer.Service.VocaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    VocaListService vocaListService;
    @PostMapping("addData")
    VocaList aaa(@RequestBody VocaList vocalist)
    {
        System.out.println("개발 타입 : " + vocalist.getDev_type());
        return vocaListService.insert(vocalist);
    }

    @PostMapping("/getNotDownloadedList")
    List<VocaList> getNotDownloadedList(@RequestBody int lastNo)
    {
        return vocaListService.findNotAddedList(lastNo);
    }


    /*
    백엔드 구현 필요 기능
    1. UI 구현 안하고 POST 요청으로 데이터를 가져온다. (POST : URL에 데이터가 안들어감)
    2. UI(App) 요청 -> Server 에서 DB 조회 -> 요청한 것에 따라 올바른 데이터를 가져옴 -> 반환
    3. 필요 기능
    3.1 단어장 가져오기
        단어장 가져오기 --> App에서 단어를 요청하면, App에 없는 단어를 가져와서 다운받도록 설정한다.   //완료
                       이거를 BackEnd에서 판단? 아니면 어떻게? 마지막 단어 번호를 Type으로 전송하고, 서버에서는 마지막 단어와 DB 번호를 대조하여 다운 받을 목록이 있다면 전송하는 걸로 한다?

    3.2 학습 완료한 단어 가져오기
      -> 학습하기 화면에서 내가 직접 학습 완료한 단어 목록
    3.3 선호 단어 목록 가져오기
      -> 학습하기 화면에서 내가 즐겨찾기에 추가한 단어를 가져온다.
    3.4 틀린 단어 가져오기
      -> 학습하기 중, 평가에서 내가 틀린 단어를 가져온다.
         틀린 단어의 경우 다시 평가하여 Pass한다면 학습 완료 단어로 넘어간다.
    3.5 단어 목록은 똑같고, 학습완료단어, 선호단어, 틀린 단어의 경우 아이디가 필요하다. -> 연동 작업 필요
     */


}
