package com.ohgiraffers.restapitest.service;

import com.ohgiraffers.restapitest.domain.dto.TestDTO;
import com.ohgiraffers.restapitest.domain.entity.TestEntity;
import com.ohgiraffers.restapitest.repository.TestRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TestService {

    private final TestRepository testRepository;

    // 게시글 조회
    public List<TestEntity> findAllPosts() {
        log.info("전체 게시글 조회 중...");
        return testRepository.findAll();
    }

    // 게시글 등록
    public TestEntity registPost(TestDTO testDTO) {
        TestEntity testEntity = new TestEntity();

        testEntity.setTitle(testDTO.getTitle());
        testEntity.setContent(testDTO.getContent());

        return testRepository.save(testEntity);
    }

    // 게시글 수정
    public TestEntity updatePost(int postId, TestDTO modifyInfo) {

        TestEntity post= testRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다. postId: " + postId));

        post = post.toBuilder()
                .title(modifyInfo.getTitle())
                .content(modifyInfo.getContent())
                .build();

        return testRepository.save(post);
    }

    // 게시글 삭제
    public void deletePostById(int postId) {

        testRepository.deleteById(postId);
    }

}
