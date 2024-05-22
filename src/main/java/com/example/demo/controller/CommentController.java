package com.example.demo.controller;

import com.example.demo.dto.comment.CommentRequestDto;
import com.example.demo.dto.comment.CommentResponseDto;
import com.example.demo.service.CommentService;
import com.example.demo.service.JwtCheckService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CommentService commentService;
    private final JwtCheckService jwtCheckService;

    @GetMapping("/all-comments")
    public ResponseEntity<List<CommentResponseDto>> getAllComments(HttpServletRequest request,
                                                                  HttpServletResponse response) {
        jwtCheckService.checkJwt(request, response);
        return ResponseEntity.ok(commentService.getAllComments());
    }

    //게시글에 있는 모든 댓글 조회
    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<List<CommentResponseDto>> getCommentsByPostId(@PathVariable Long postId,
                                                        HttpServletRequest request,
                                                        HttpServletResponse response) {
        jwtCheckService.checkJwt(request, response);
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    //회원이 작성한 모든 댓글 조회
    @GetMapping("/user/{userId}/comments")
    public ResponseEntity<List<CommentResponseDto>> getCommentsByUserId(@PathVariable String userId,
                                                        HttpServletRequest request,
                                                        HttpServletResponse response) {
        jwtCheckService.checkJwt(request, response);
        return ResponseEntity.ok(commentService.getCommentsByUserId(userId));
    }

    @PostMapping("/create/{postId}")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto commentRequestDto,
                                            @PathVariable Long postId,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        String userId = jwtCheckService.checkJwt(request, response);

        return ResponseEntity.ok(commentService.createComment(commentRequestDto, userId, postId));
    }

    @PostMapping("/update/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(@RequestBody CommentRequestDto commentRequestDto,
                                            @PathVariable Long commentId,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {

        String userId = jwtCheckService.checkJwt(request, response);
        return ResponseEntity.ok(commentService.updateComment(commentRequestDto, commentId, userId));
    }

    @DeleteMapping("/{commentId}/delete")
    public ResponseEntity<String> deleteArticleComment(@PathVariable Long commentId,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {

        String userId = jwtCheckService.checkJwt(request, response);

        commentService.deleteArticleComment(commentId, userId);
        return ResponseEntity.ok().body("DELETE_SUCCESS");
    }

}
