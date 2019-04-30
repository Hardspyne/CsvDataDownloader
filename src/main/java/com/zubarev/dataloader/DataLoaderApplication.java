package com.zubarev.dataloader;

import com.zubarev.dataloader.entity.TestData;
import com.zubarev.dataloader.service.TestDataServiceImpl;
import com.zubarev.dataloader.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
public class DataLoaderApplication implements CommandLineRunner {

    @Autowired
    private TestDataServiceImpl testDataService;

    public static void main(String[] args) {
        SpringApplication.run(DataLoaderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        InputStream fileInputStream = new FileInputStream("unprocessed data/source.csv");

        testDataService.saveAll(CsvUtils.read(TestData.class,fileInputStream));
    }
}
