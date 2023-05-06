package com.DevVoca.backendServer.Repository;


import com.DevVoca.backendServer.Model.FavoriteVocaGroup;
import com.DevVoca.backendServer.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteVocaGroupRepository extends JpaRepository<FavoriteVocaGroup,Integer> {

    List<FavoriteVocaGroup> findByUserInfo_UserNo(@Param(value = "userInfo")int userInfo);

}
