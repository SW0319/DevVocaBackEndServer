package com.DevVoca.backendServer.Scheduler;


import com.DevVoca.backendServer.Repository.SearchedVocaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class RemoveSearchedVocaTask{

    @Autowired
    SearchedVocaRepository searchedVocaRepository;

    @Scheduled(fixedRate = 1000 * 60 * 60, initialDelay = 1000*5)
    @Transactional
    public void executeTask()
    {
        searchedVocaRepository.deleteAfter24Hours();
    }
}
