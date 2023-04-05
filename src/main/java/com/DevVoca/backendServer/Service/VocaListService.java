package com.DevVoca.backendServer.Service;


import com.DevVoca.backendServer.Model.VocaList;
import com.DevVoca.backendServer.Repository.VocaListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocaListService {

    @Autowired
    VocaListRepository vocaListRepository;
    public VocaList insert(VocaList vocaList)
    {
            return vocaListRepository.save(vocaList);
    }
    public List<VocaList> findNotAddedList(int lastAddNo)
    {
        return vocaListRepository.findNotAddVocaList(lastAddNo);
    }


}
