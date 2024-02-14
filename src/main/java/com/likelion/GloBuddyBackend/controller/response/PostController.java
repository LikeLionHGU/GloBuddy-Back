package com.likelion.GloBuddyBackend.controller.response;

import com.likelion.GloBuddyBackend.service.PostService;
import com.likelion.GloBuddyBackend.controller.request.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse> addPost(@RequestBody PostRequest form) {

    }
    @GetMapping
    public ResponseEntity<ApiResponse> getAllPosts(){

    }
    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse> getPost(@PathVariable Long postId){

    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long postId) {

    }

}
