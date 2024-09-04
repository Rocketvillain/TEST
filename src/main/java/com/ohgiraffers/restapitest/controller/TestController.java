package com.ohgiraffers.restapitest.controller;

import com.ohgiraffers.restapitest.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

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
