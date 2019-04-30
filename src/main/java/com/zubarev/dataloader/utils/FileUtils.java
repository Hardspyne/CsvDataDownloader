package com.zubarev.dataloader.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class FileUtils {

    public static File[] getAllCsvFiles(String path) throws FileNotFoundException {
        File unprocessedFolder = new File(path);
        File[] unprocessedFiles= unprocessedFolder.listFiles();

        if (unprocessedFiles != null) {
            return Arrays.stream(unprocessedFiles)
                    .filter(file -> file.toString().endsWith(".csv"))
                    .toArray(File[]::new);
        }
        else {
            throw new FileNotFoundException();
        }
    }
}
