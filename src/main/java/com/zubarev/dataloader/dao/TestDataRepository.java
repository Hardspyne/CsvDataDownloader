package com.zubarev.dataloader.dao;

import com.zubarev.dataloader.entity.TestData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDataRepository extends JpaRepository<TestData, Integer> {
}
