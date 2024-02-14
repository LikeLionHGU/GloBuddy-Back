package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.repository.PostRepository;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Long addPost(PostDto postDto) {

    }

    public List<PostDto> getAllPosts(int pageNumber, int pageSize) {

    }


    public void deletePost(Long postId) {

    }

}
