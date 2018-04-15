package com.itplace.volshin.summary;

import com.itplace.volshin.summary.service.api.SummaryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SummaryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SummaryApplication.class, args);
        SummaryService summaryService = context.getBean("summaryServiceImp", SummaryService.class);
        summaryService.open("input.properties");
    }
}
