package com.zubarev.dataloader.service;

import com.zubarev.dataloader.dao.TestDataRepository;
import com.zubarev.dataloader.entity.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestDataServiceImpl implements TestDataService {

    private TestDataRepository testDataRepository;

    @Autowired
    public TestDataServiceImpl(TestDataRepository testDataRepository) {
        this.testDataRepository = testDataRepository;
    }

    @Override
    public void saveAll(Iterable<TestData> iterable) {
         testDataRepository.saveAll(iterable);
    }
}
