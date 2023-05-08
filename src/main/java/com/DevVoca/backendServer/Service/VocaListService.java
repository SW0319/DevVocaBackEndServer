package com.DevVoca.backendServer.Service;


import com.DevVoca.backendServer.Model.VocaList;
import com.DevVoca.backendServer.Repository.VocaListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if(lastAddNo == -1)
            return vocaListRepository.getAllVocaLists();

        return vocaListRepository.getNotAddedVocaLists(lastAddNo);
    }

    public VocaList findById(int v_no)
    {
        Optional<VocaList> vocaList =vocaListRepository.findById(v_no);
        if(vocaList.isPresent())
        {
            return vocaList.get();
        }
        else
        {
            return null;
        }
    }


}
