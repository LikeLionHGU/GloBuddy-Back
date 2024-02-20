package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.domain.Needs;
import com.likelion.GloBuddyBackend.dto.NeedsDto;
import com.likelion.GloBuddyBackend.repository.PostRepository;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.likelion.GloBuddyBackend.dto.PostDto;
import com.likelion.GloBuddyBackend.domain.Post;
import com.likelion.GloBuddyBackend.domain.Member;
import java.util.List;
import java.util.Optional;
import com.likelion.GloBuddyBackend.exception.PostNotFoundException;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.repository.NeedsRepository;



@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final NeedsRepository needsRepository;

    public Long addPost(PostDto postDto) {
        Member member = memberRepository.findById(postDto.getMemberId()).orElseThrow(MemberNotFoundException::new);
        Post post = postRepository.save(Post.toPost(postDto, member)) ;
        NeedsDto needsDto = NeedsDto.from(postDto);
        Needs needs = Needs.toNeeds(needsDto,post);
        needsRepository.save(needs);
        return post.getPostId();
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAllByDeletedFalse();

         return posts.stream()
                .map(postInfo -> {
                    Needs needs = needsRepository.findAllByPosts(postInfo.getPostId());
                    return PostDto.from(postInfo,needs);
                    })
                    .toList();

    }

    public List<PostDto> getAllPostsIncludeDeleted() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostDto::from).toList();
    }

    public List<PostDto> getPostsByMemberId(Long memberId) { // 멤버 id 받아온걸로 멤버가 있는지 확인해주고 없으면 오류
        Optional<Member> member = memberRepository.findById(memberId);
        List<Post> posts = postRepository.findAllByMember(member);
        return posts.stream().map(PostDto::from).toList();
    }


    public PostDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        return PostDto.from(post);
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException());
        post.delete(post);
        PostDto.from(post);
        postRepository.save(post); // 엔티티형태로 저장되어야함
    }

    public void updatePost(Long postId, PostDto postDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException());
        post.update(postDto);
        postRepository.save(post);
    }



}
