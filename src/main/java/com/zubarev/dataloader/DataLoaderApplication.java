package com.zubarev.dataloader;

import com.zubarev.dataloader.entity.TestData;
import com.zubarev.dataloader.service.TestDataServiceImpl;
import com.zubarev.dataloader.utils.CsvUtils;
import com.zubarev.dataloader.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class DataLoaderApplication implements CommandLineRunner {

    @Value("${folder.unprocessed_data}")
    private String unprocessedDataFolderName;
    @Value("${folder.processed_data}")
    private String processedDataFolderName;

    @Autowired
    private TestDataServiceImpl testDataService;

    public static void main(String[] args) {
        SpringApplication.run(DataLoaderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        File[] unprocessedFiles = FileUtils.getAllCsvFiles(unprocessedDataFolderName);

        for (File file : unprocessedFiles) {

            try (InputStream fileInputStream = new FileInputStream(file)) {
                testDataService.saveAll(CsvUtils.read(TestData.class, fileInputStream));
            }

            Files.move(file.toPath(),
                    Paths.get(processedDataFolderName +"/" + file.getName()));
        }
    }
}
