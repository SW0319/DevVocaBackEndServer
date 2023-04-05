package com.DevVoca.backendServer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class UserInfo {

    @Id
    int user_No;

}
