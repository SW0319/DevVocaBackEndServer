package com.DevVoca.backendServer.Service;

import com.DevVoca.backendServer.Dto.CompleteVocaDto;
import com.DevVoca.backendServer.Model.CompleteVoca;
import com.DevVoca.backendServer.Model.UserInfo;
import com.DevVoca.backendServer.Model.VocaList;
import com.DevVoca.backendServer.Repository.CompleteVocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompleteVocaService {

    @Autowired
    CompleteVocaRepository completeVocaRepository;


    public CompleteVocaDto saveVocaComplete(UserInfo userInfo, VocaList vocaList)
    {
        CompleteVoca completeVoca = completeVocaRepository.save(new CompleteVoca(userInfo,vocaList));
        return new CompleteVocaDto(completeVoca.getUserInfo().getUserNo(), completeVoca.getVocaNo().getV_no(), completeVoca.getCompleteTime());
    }

    public List<CompleteVocaDto> getCompleteVocaListByUserInfo(UserInfo userInfo)
    {
        List<CompleteVocaDto> completeVocaDtos = new ArrayList<>();
        List<CompleteVoca> completeVocas = completeVocaRepository.findByUserInfo_UserNo(userInfo.getUserNo());
        for (CompleteVoca completeVoca : completeVocas) {
            completeVocaDtos.add(new CompleteVocaDto(userInfo.getUserNo(), completeVoca.getVocaNo().getV_no(), completeVoca.getCompleteTime()));
        }
        return completeVocaDtos;
    }


}
