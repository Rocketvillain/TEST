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
@Transactional( readOnly = true)
public class TestService {

    private final TestRepository testRepository;

    public void updatePost(int postId, TestDTO modifyInfo) {

        TestEntity post= testRepository.findById(postId)
                .orElseThrow();

        post = post.toBuilder()
                .title(modifyInfo.getTitle())
                .content(modifyInfo.getContent())
                .build();

        testRepository.save(post);
    }
}
