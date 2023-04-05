package com.DevVoca.backendServer.Repository;

import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Model.VocaList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Integer> {

    @Query(value = "select count(*) from user_info where userID = :parameter_UserID", nativeQuery = true)
    int findByuserID(String parameter_UserID);

}
