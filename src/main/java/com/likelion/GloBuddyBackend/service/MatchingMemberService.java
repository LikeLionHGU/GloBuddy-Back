package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.Post;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import com.likelion.GloBuddyBackend.dto.PostDto;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.exception.PostNotFoundException;
import com.likelion.GloBuddyBackend.repository.MatchingMemberRepository;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import com.likelion.GloBuddyBackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchingMemberService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final MatchingMemberRepository matchingMemberRepository;

    public Long createMatchingRequest(MemberDto memberDto, PostDto postDto) {
        Long senderId = memberDto.getMemberId();
        Member sender = memberRepository.findById(senderId).orElseThrow(MemberNotFoundException::new);

        Long receiverId = postDto.getPostId();
        Post receiverPostId = postRepository.findById(receiverId).orElseThrow(PostNotFoundException::new);

        MatchingMember matchingMember = MatchingMember.of(sender, receiverPostId);
        MatchingMember saved = matchingMemberRepository.save(matchingMember);

        return saved.getMatchingId();
    }



}
