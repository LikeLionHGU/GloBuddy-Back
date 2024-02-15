package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.dto.MemberDto;
import com.likelion.GloBuddyBackend.repository.PostRepository;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.likelion.GloBuddyBackend.dto.PostDto;
import com.likelion.GloBuddyBackend.domain.Post;
import com.likelion.GloBuddyBackend.domain.Member;
import java.util.List;
import com.likelion.GloBuddyBackend.exception.PostNotFoundException;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.controller.response.Post.PostResponse;
import com.likelion.GloBuddyBackend.controller.response.Post.PostListResponse;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Long addPost(PostDto postDto) {
        Member member = memberRepository.findById(postDto.getMemberId()).orElseThrow(MemberNotFoundException::new);
        Post post = postRepository.save(Post.toPost(postDto, member)) ;
        return post.getPostId();
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostDto::from).toList();
    }

    public PostDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        return PostDto.from(post);
    }


    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public void updatePost(Long postId,  PostDto postDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException());
        post.update(postDto);
        postRepository.save(post);
    }

}
