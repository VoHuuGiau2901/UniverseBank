package com.ec.final_project.Utils;

import com.ec.final_project.Services.Services.saving_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.ec.final_project.Utils.ControllerUtils.timeFormat;

@Component
public class SavingAccountCheck {
    @Autowired
    saving_accountService service;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        System.out.println("Scheduler: the time is now {}" + timeFormat.format(new Date()));
//        service.checkandUpdate();
    }
}
