package com.DevVoca.backendServer.Repository;


import com.DevVoca.backendServer.Model.FavoriteVocaGroup;
import com.DevVoca.backendServer.Model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FavoriteVocaGroupRepository extends CrudRepository<FavoriteVocaGroup, Integer> {

    @Query(value = "SELECT * from FavoriteVocaGroup where UserInfo := userInfo", nativeQuery = true)
    List<FavoriteVocaGroup> getMyFavoriteVocaGroup(UserInfo userInfo);

}
