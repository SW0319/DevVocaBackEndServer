package com.DevVoca.backendServer.Repository;

import com.DevVoca.backendServer.Model.VocaList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VocaListRepository extends CrudRepository<VocaList,Integer> {


    @Query(value = "SELECT * FROM voca_list where v_no > :lastNo", nativeQuery = true)
    List<VocaList> findNotAddVocaList(int lastNo);

}
