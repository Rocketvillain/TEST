package com.ohgiraffers.restapitest.comment.controller;

import com.ohgiraffers.restapitest.comment.domain.dto.CommentDTO;
import com.ohgiraffers.restapitest.comment.domain.dto.CreateCommentDTO;
import com.ohgiraffers.restapitest.comment.domain.entity.CommentEntity;
import com.ohgiraffers.restapitest.comment.service.CommentService;
import com.ohgiraffers.restapitest.common.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/comments")
@Slf4j
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 특정 게시글의 댓글 조회
    @Operation(summary = "특정 게시글의 댓글 조회")
    @GetMapping("/{postId}")
    public ResponseEntity<ResponseMessage> findCommentsByPost(@PathVariable int postId) {

        List<CommentEntity> comment = commentService.findCommentsByPost(postId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("comment", comment);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, postId+"번 게시글의 댓글들을 불러옵니다...", responseMap));
    }

    @Operation(summary = "전체 댓글 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllComments() {

        List<CommentEntity> comment = commentService.findAllComments();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("comment", comment);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "모든 댓글들을 불러옵니다...", responseMap));
    }




    // 댓글 등록
    @PostMapping("")
    @Operation(summary = "댓글 등록")
    public ResponseEntity<ResponseMessage> regist(@RequestBody CreateCommentDTO commentDTO) {

        CommentEntity savedComment = commentService.registComment(commentDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("comment", savedComment);

        return ResponseEntity
                .created(URI.create("/comments/" + savedComment.getCommentId()))
                .body(new ResponseMessage(HttpStatus.CREATED, savedComment.getPostId().getPostId()+"번 게시글의 댓글 등록 성공~!", responseMap));
    }

//    // post 수정
//    @Operation(summary = "댓글 수정", description = "우리 사이트 댓글 수정")
//    @PutMapping("/{postId}")
//    public ResponseEntity<ResponseMessage> modifyPost(@PathVariable int postId, @RequestBody CommentDTO modifyInfo) {
//
//        CommentEntity updatedPost = commentService.updatePost(postId, modifyInfo);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("post", updatedPost);
//
//        return ResponseEntity.created(URI.create("/entity/TestEntity/" + postId))
//                .body(new ResponseMessage(HttpStatus.OK, "댓글 수정 성공", responseMap));
//    }
//
//    // 댓글 삭제
//    @Operation(summary = "댓글 삭제")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "댓글 삭제 성공!"),
//            //  204 No Content 대신 200 OK를 사용하여 본문에 메시지를 포함할 수 있게 했다.
//            @ApiResponse(responseCode = "400", description = "잘못 입력된 파라미터")
//    })
//    @DeleteMapping("/{postId}")
//    public ResponseEntity<ResponseMessage> deletePost(@PathVariable int postId) {
//
//        commentService.deletePostById(postId);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("message", "댓글 삭제 성공");
//
//        return ResponseEntity.ok()
//                .body(new ResponseMessage(HttpStatus.OK, "댓글 삭제 성공", responseMap));
//
//    }


}
