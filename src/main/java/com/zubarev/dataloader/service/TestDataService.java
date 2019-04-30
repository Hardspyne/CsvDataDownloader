package com.zubarev.dataloader.service;

import com.zubarev.dataloader.entity.TestData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestDataService {
    List<TestData> findAll();
}
