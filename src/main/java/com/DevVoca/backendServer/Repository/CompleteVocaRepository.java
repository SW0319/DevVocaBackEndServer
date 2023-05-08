package com.DevVoca.backendServer.Repository;

import com.DevVoca.backendServer.Model.CompleteVoca;
import com.DevVoca.backendServer.Model.FavoriteVocaGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompleteVocaRepository extends JpaRepository<CompleteVoca, Integer> {

    List<CompleteVoca> findByUserInfo_UserNo(@Param(value = "userInfo")int userInfo);

}
