package com.DevVoca.backendServer.Model;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
public class CompleteVoca {

    @Id @GeneratedValue
    int no;
    @JoinColumn(name = "vocaNo") @ManyToOne   //TODO : Join할지, 쉼표로 구분하여 단어 번호들을 넣을지는 고민
    VocaList vocaNo;

    @JoinColumn(name = "userNo") @ManyToOne
    UserInfo userInfo;

    @CreationTimestamp
    LocalDateTime completeTime;

    public CompleteVoca(UserInfo userInfo, VocaList vocaList)
    {
        this.userInfo = userInfo;
        vocaNo = vocaList;
    }

    public CompleteVoca()
    {

    }


}
