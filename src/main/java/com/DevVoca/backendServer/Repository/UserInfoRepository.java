package com.DevVoca.backendServer.Repository;

import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Model.VocaList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Integer> {

    @Query(value = "select * from user_info where userID = :parameter_UserID", nativeQuery = true)
    UserInfo findByuserID(String parameter_UserID);

}
