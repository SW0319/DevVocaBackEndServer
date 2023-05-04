package com.DevVoca.backendServer.Repository;


import com.DevVoca.backendServer.Model.FavoriteVocaGroup;
import com.DevVoca.backendServer.Model.UserInfo;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FavoriteVocaGroupRepository extends CrudRepository<FavoriteVocaGroup, Integer> {

    @Query(value = "SELECT * from FavoriteVocaGroup where UserInfo := userInfo", nativeQuery = true)    //UserInfo 객체를 이렇게 넣어도 데이터를 받을 수 있나?
    List<FavoriteVocaGroup> getMyFavoriteVocaGroup(UserInfo userInfo);

}
