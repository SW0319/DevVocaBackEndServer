package com.DevVoca.backendServer.Controller;


import com.DevVoca.backendServer.Dto.CompleteVocaDto;
import com.DevVoca.backendServer.Model.*;
import com.DevVoca.backendServer.Service.CompleteVocaService;
import com.DevVoca.backendServer.Service.FavoriteVocaGroupService;
import com.DevVoca.backendServer.Service.LoginService;
import com.DevVoca.backendServer.Service.VocaListService;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RestController
@RequestMapping("/api/word")
public class VocaController {

    @Autowired
    VocaListService vocaListService;
    @Autowired
    FavoriteVocaGroupService favoriteVocaGroupService;

    @Autowired
    CompleteVocaService completeVocaService;

    @Autowired  //TODO : 제거하고 다른 방법을 고민해야됨
    LoginService loginService;

    @PostMapping("/downloadAllLists")
    List<VocaList> downloadAllLists()
    {
        return vocaListService.findNotAddedList(-1);
    }

    @PostMapping("/downloadNotAddedLists")
    List<VocaList> downloadNotAddedLists(@RequestBody VocaList vocaList)
    {
        return vocaListService.findNotAddedList(vocaList.getV_no());
    }

    @PostMapping("/getFVocaGroup")
    List<FavoriteVocaGroup> getFavoriteVocaGroup(@RequestBody UserInfo userInfo)
    {
        return favoriteVocaGroupService.getFavoriteVocaGroup(userInfo);
    }

    @PostMapping("/addFVocaGroup")
    FavoriteVocaGroup addFavoriteVocaGroup(@RequestBody FavoriteVocaGroup favoriteVocaGroup)
    {
        return favoriteVocaGroupService.addFavoriteVocaGroup(favoriteVocaGroup);
    }

    @PostMapping("/removeVocaGroup")
    void removeVocaGroup(@RequestBody FavoriteVocaGroup favoriteVocaGroup)
    {
        favoriteVocaGroupService.removeFavoriteVocaGroup(favoriteVocaGroup);
    }


    @PostMapping("/saveVocaComplete")
    CompleteVocaDto saveVocaComplete(@RequestBody CompleteVocaDto completeVocaDto)
    {
        VocaList vocaList = vocaListService.findById(completeVocaDto.getV_no());
        UserInfo userInfo = loginService.findById(completeVocaDto.getUserNo());
        return completeVocaService.saveVocaComplete(userInfo, vocaList);
    }

    @PostMapping("/getCompleteVocaList")
    List<CompleteVocaDto> getCompleteVocaListByUserInfo(@RequestBody UserInfo userInfo)
    {
        return completeVocaService.getCompleteVocaListByUserInfo(userInfo);
    }
    @PostMapping("/updateFavoriteVocaLists")
    FavoriteVocaGroup updateFavoriteVocaLists(@RequestBody FavoriteVocaGroup favoriteVocaGroup)
    {
        return favoriteVocaGroupService.updateFavoriteVocaGroup(favoriteVocaGroup);
    }

}
