package com.DevVoca.backendServer.Dto;

import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Model.VocaList;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CompleteVocaDto {

    int userNo;
    int v_no;
    LocalDateTime completeTime;

    public CompleteVocaDto()
    {

    }


    public CompleteVocaDto(int userNo, int v_no, LocalDateTime completeTime)
    {
        this.userNo = userNo;
        this.v_no = v_no;
        this.completeTime = completeTime;
    }

}
