package com.DevVoca.backendServer.Controller;


import com.DevVoca.backendServer.Model.*;
import com.DevVoca.backendServer.Service.FavoriteVocaGroupService;
import com.DevVoca.backendServer.Service.VocaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/word")
public class VocaController {

    @Autowired
    VocaListService vocaListService;
    @Autowired
    FavoriteVocaGroupService favoriteVocaGroupService;

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
    List<FavoriteVocaGroup> getFavoriteVocaGroup(UserInfo userInfo)
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


}
