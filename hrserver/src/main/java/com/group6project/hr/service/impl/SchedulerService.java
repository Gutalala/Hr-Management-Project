package com.group6project.hr.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SchedulerService {

    @Scheduled(cron = "0 0 */3 * * *")
    public void printCronMessage(){
        log.info("Scheduling Cron test");
    }

    @Scheduled(fixedRate = 1000*60*60*3)
    public void logFixedRateMessage(){
        log.info("Schedule Fixed Rate Test 2");
    }

}
