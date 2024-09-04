package com.ohgiraffers.restapitest.controller;

import com.ohgiraffers.restapitest.domain.dto.TestDTO;
import com.ohgiraffers.restapitest.domain.entity.TestEntity;
import com.ohgiraffers.restapitest.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;


//    @PostMapping("")
//    public ResponseEntity<?> regist(@RequestParam String title, @RequestParam String content) {
//
//        log.info(title);
//        log.info(content);
//
//        TestDTO createPost = new TestDTO(title, content);
//
//        TestEntity savedTest =  testService.registPost(createPost);
//
//        return ResponseEntity
//                .created(URI.create("/posts/" + savedTest.getPostId()))
//                .body(savedTest);
//    }

    @PostMapping("")
    public ResponseEntity<?> regist(@RequestBody TestDTO testDTO) {

        TestEntity savedTest =  testService.registPost(testDTO);

        return ResponseEntity
                .created(URI.create("/posts/" + savedTest.getPostId()))
                .body(savedTest);
    }

}
