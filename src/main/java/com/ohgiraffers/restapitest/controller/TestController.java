package com.ohgiraffers.restapitest.controller;

import com.ohgiraffers.restapitest.domain.dto.TestDTO;
import com.ohgiraffers.restapitest.domain.entity.TestEntity;
import com.ohgiraffers.restapitest.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
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


    // 게시글 등록
    @PostMapping("")
    public ResponseEntity<?> regist(@RequestBody TestDTO testDTO) {

        TestEntity savedTest =  testService.registPost(testDTO);

        return ResponseEntity
                .created(URI.create("/posts/" + savedTest.getPostId()))
                .body(savedTest);
    }


    // 게시글 삭제
    @Operation(summary = "게시글 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "게시글 삭제 성공!"),
            @ApiResponse(responseCode = "400", description = "잘못 입력된 파라미터")
    })
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable int postId) {

    testService.deletePostById(postId);

    return ResponseEntity.noContent().build();
    }


}
