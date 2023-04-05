package com.DevVoca.backendServer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "User_Info")
public class UserInfo {

    @Id
    @GeneratedValue
    int user_No;
    String userID; //고유한 값임
    String email;
    String userName;

    public UserInfo(){}

    public UserInfo(String userID, String email, String userName){
        this.userID = userID;
        this.email = email;
        this.userName = userName;
    }


}
