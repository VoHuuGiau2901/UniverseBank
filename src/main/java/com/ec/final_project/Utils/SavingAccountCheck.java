package com.ec.final_project.Utils;

import com.ec.final_project.Services.Services.saving_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SavingAccountCheck {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    saving_accountService service;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        System.out.println("Scheduler: the time is now {}" + dateFormat.format(new Date()));
//        service.checkandUpdate();
    }
}
