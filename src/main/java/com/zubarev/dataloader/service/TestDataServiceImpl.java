package com.zubarev.dataloader.service;

import com.zubarev.dataloader.dao.TestDataRepository;
import com.zubarev.dataloader.entity.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDataServiceImpl implements TestDataService {

    private TestDataRepository testDataRepository;

    @Autowired
    public TestDataServiceImpl(TestDataRepository testDataRepository) {
        this.testDataRepository = testDataRepository;
    }

    @Override
    public List<TestData> findAll() {
        return testDataRepository.findAll();
    }

}
