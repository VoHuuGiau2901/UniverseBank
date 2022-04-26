package com.ec.final_project.Services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class UpdateMoneyService extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                com.ec.final_project.Controllers.UpdateMoneyController.check_and_update();
                Thread.sleep(86400000);  // official
//                Thread.sleep(60000); // test
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
