package com.DevVoca.backendServer.Repository;

import com.DevVoca.backendServer.Model.SearchedVoca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SearchedVocaRepository extends JpaRepository<SearchedVoca, Integer> {


    @Modifying
    @Query(value = "delete from Searched_voca where datediff('dd',create_time,now()) >=1", nativeQuery = true)
    void deleteAfter24Hours();

}
