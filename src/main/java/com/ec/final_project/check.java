package com.ec.final_project;

import com.ec.final_project.Controllers.checkModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class check extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                checkModel.check_and_update();
                Thread.sleep(86400000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
