package com.DevVoca.backendServer.Service;

import com.DevVoca.backendServer.Model.FavoriteVocaGroup;
import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Model.VocaList;
import com.DevVoca.backendServer.Repository.FavoriteVocaGroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteVocaGroupService {

    @Autowired
    FavoriteVocaGroupRepository favoriteVocaGroupRepository;

    //TODO : favoriteVocaGroup 내부의 UserInfo가 유효한 정보인지 확인하도록 구현해야할까?
    public FavoriteVocaGroup addFavoriteVocaGroup(FavoriteVocaGroup favoriteVocaGroup)
    {
        return favoriteVocaGroupRepository.save(favoriteVocaGroup);
    }

    public List<FavoriteVocaGroup> getFavoriteVocaGroup(UserInfo userInfo)
    {
        return favoriteVocaGroupRepository.findByUserInfo_UserNo(userInfo.getUserNo());
    }

    public void removeFavoriteVocaGroup(FavoriteVocaGroup favoriteVocaGroup)
    {
        favoriteVocaGroupRepository.delete(favoriteVocaGroup);
    }
    @Transactional
    public FavoriteVocaGroup updateFavoriteVocaGroup(FavoriteVocaGroup favoriteVocaGroup)
    {
        FavoriteVocaGroup favoriteVocaGroup1 = favoriteVocaGroupRepository.findById(favoriteVocaGroup.getGroup_No()).get();
        favoriteVocaGroup1.setFavoriteVocaListArray(favoriteVocaGroup.getFavoriteVocaListArray());
        return favoriteVocaGroup1;
    }
}
