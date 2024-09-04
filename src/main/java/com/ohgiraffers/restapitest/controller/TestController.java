package com.ohgiraffers.restapitest.controller;

import com.ohgiraffers.restapitest.common.ResponseMessage;
import com.ohgiraffers.restapitest.domain.dto.TestDTO;
import com.ohgiraffers.restapitest.domain.entity.TestEntity;
import com.ohgiraffers.restapitest.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/posts")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    // 게시글 전체 조회
    @Operation(summary = "게시글 전체 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllPosts() {

        List<TestEntity> posts = testService.findAllPosts();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("posts", posts);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "게시글 전체 조회 성공", responseMap));
    }


    // 게시글 등록
    @PostMapping("")
    @Operation(summary = "게시글 등록")
    public ResponseEntity<ResponseMessage> regist(@RequestBody TestDTO testDTO) {

        TestEntity savedTest = testService.registPost(testDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("post", savedTest);

        return ResponseEntity
                .created(URI.create("/posts/" + savedTest.getPostId()))
                .body(new ResponseMessage(HttpStatus.CREATED, "게시글 등록 성공", responseMap));
    }

    // post 수정
    @Operation(summary = "게시글 수정", description = "우리 사이트 게시글 수정")
    @PutMapping("/{postId}")
    public ResponseEntity<ResponseMessage> modifyPost(@PathVariable int postId, @RequestBody TestDTO modifyInfo) {

        TestEntity updatedPost = testService.updatePost(postId, modifyInfo);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("post", updatedPost);

        return ResponseEntity.created(URI.create("/entity/TestEntity/" + postId))
                .body(new ResponseMessage(HttpStatus.OK, "게시글 수정 성공", responseMap));
    }

    // 게시글 삭제
    @Operation(summary = "게시글 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "게시글 삭제 성공!"),
            //  204 No Content 대신 200 OK를 사용하여 본문에 메시지를 포함할 수 있게 했다.
            @ApiResponse(responseCode = "400", description = "잘못 입력된 파라미터")
    })
    @DeleteMapping("/{postId}")
    public ResponseEntity<ResponseMessage> deletePost(@PathVariable int postId) {

        testService.deletePostById(postId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", "게시글 삭제 성공");

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "게시글 삭제 성공", responseMap));

    }


}
