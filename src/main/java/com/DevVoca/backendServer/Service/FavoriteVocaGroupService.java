package com.DevVoca.backendServer.Service;

import com.DevVoca.backendServer.Model.FavoriteVocaGroup;
import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Repository.FavoriteVocaGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteVocaGroupService {

    @Autowired
    FavoriteVocaGroupRepository favoriteVocaGroupRepository;

    //TODO : favoriteVocaGroup 내부의 UserInfo가 유효한 정보인지 확인하도록 구현해야함??
    public FavoriteVocaGroup addFavoriteVocaGroup(FavoriteVocaGroup favoriteVocaGroup)
    {
        return favoriteVocaGroupRepository.save(favoriteVocaGroup);
    }

    public List<FavoriteVocaGroup> getFavoriteVocaGroup(UserInfo userInfo)
    {
        return favoriteVocaGroupRepository.getMyFavoriteVocaGroup(userInfo);
    }

    public void removeFavoriteVocaGroup(FavoriteVocaGroup favoriteVocaGroup)
    {
        favoriteVocaGroupRepository.delete(favoriteVocaGroup);
    }


}
