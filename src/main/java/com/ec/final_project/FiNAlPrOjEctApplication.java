package com.ec.final_project;

import com.ec.final_project.Services.UpdateMoneyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiNAlPrOjEctApplication {

    public static void main(String[] args) {

        SpringApplication.run(FiNAlPrOjEctApplication.class, args);
        UpdateMoneyService c1 = new UpdateMoneyService();
        c1.start();
    }

}
