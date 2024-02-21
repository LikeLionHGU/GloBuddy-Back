package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.repository.PostRepository;
import com.likelion.GloBuddyBackend.service.PostService;
import com.likelion.GloBuddyBackend.controller.request.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.likelion.GloBuddyBackend.dto.PostDto;
import com.likelion.GloBuddyBackend.controller.response.Post.PostResponse;
import com.likelion.GloBuddyBackend.controller.response.Post.PostIdResponse;
import com.likelion.GloBuddyBackend.controller.response.Post.PostListResponse;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping
    public ResponseEntity<ApiResponse> addPost(@RequestBody PostRequest form) {
        Long postId = postService.addPost(PostDto.from(form));
        ApiResponse response = new PostIdResponse(postId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllPosts(){
        List<PostDto> postsDto = postService.getAllPosts();
        ApiResponse response = new PostListResponse(postsDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/test") // 삭제된 게시물까지
    public ResponseEntity<ApiResponse> getAllPostsIncludeDeleted(){
        List<PostDto> postsDto = postService.getAllPostsIncludeDeleted();
        ApiResponse response = new PostListResponse(postsDto);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/mypost/{memberId}")
    public ResponseEntity<ApiResponse> getPostsByMemberID(@PathVariable Long memberId){
        List<PostDto> postsDto = postService.getPostsByMemberId(memberId);
        ApiResponse response = new PostListResponse(postsDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse> getPost(@PathVariable Long postId) {
        PostDto post = postService.getPost(postId);
        ApiResponse response = new PostResponse(post);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        ApiResponse response = new PostIdResponse(postId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<ApiResponse> updatePost(@PathVariable Long postId, @RequestBody PostRequest postRequest){
        postService.updatePost(postId, PostDto.from(postRequest));
        ApiResponse response = new PostIdResponse(postId);
        return ResponseEntity.ok(response);
    }




}
