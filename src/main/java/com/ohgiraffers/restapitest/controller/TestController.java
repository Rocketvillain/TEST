package com.ohgiraffers.restapitest.controller;

import com.ohgiraffers.restapitest.domain.dto.TestDTO;

import com.ohgiraffers.restapitest.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/posts")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;


    // post 수정
    @Operation(summary = "게시글 수정", description = "우리 사이트 게시글 수정")
    @PutMapping("/{postId}")
    public ResponseEntity<?> modifyPost(@PathVariable int postId,@RequestBody TestDTO modifyInfo){


        testService.updatePost(postId, modifyInfo);

        return ResponseEntity.created(URI.create("/entity/TestEntity/" + postId)).build();
    }
}
