package com.zubarev.dataloader;

import com.zubarev.dataloader.service.TestDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataLoaderApplication implements CommandLineRunner {

    @Autowired
    private TestDataServiceImpl testDataService;

    public static void main(String[] args) {
        SpringApplication.run(DataLoaderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(testDataService.findAll());
    }
}
