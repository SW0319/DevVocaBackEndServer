package com.DevVoca.backendServer.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "User_Info")
public class UserInfo {

    @Id
    @GeneratedValue
    int userNo;
    String userID; //고유한 값임
    String email;
    String userName;


    @CreationTimestamp
    LocalDateTime registerDate;

    @UpdateTimestamp
    LocalDateTime lastLoginDate;
    int loginStreak = 1;

    public  UserInfo()
    {

    }

}
