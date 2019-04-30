package com.zubarev.dataloader.service;

import com.zubarev.dataloader.entity.TestData;
import org.springframework.stereotype.Service;

@Service
public interface TestDataService {
    void saveAll(Iterable<TestData> iterable);
}
