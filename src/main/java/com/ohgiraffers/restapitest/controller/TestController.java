package com.ohgiraffers.restapitest.controller;

import com.ohgiraffers.restapitest.domain.entity.TestEntity;
import com.ohgiraffers.restapitest.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    // 게시글 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<List<TestEntity>> findAllPosts(){

        List<TestEntity> posts = testService.findAllPosts();

        return ResponseEntity.ok(posts);
    }

}
