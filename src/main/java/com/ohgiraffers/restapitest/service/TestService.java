package com.ohgiraffers.restapitest.service;

import com.ohgiraffers.restapitest.domain.dto.TestDTO;
import com.ohgiraffers.restapitest.domain.entity.TestEntity;
import com.ohgiraffers.restapitest.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TestService {

    private final TestRepository testRepository;

    public TestEntity registPost(TestDTO testDTO) {
        TestEntity testEntity = new TestEntity();

        testEntity.setTitle(testDTO.getTitle());
        testEntity.setContent(testDTO.getContent());

        return testRepository.save(testEntity);
    }

    public void deletePostById(int postId) {

        testRepository.deleteById(postId);
    }
}
