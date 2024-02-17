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

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingMemberService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final MatchingMemberRepository matchingMemberRepository;

    public MatchingMember createMatchingRequest(Long senderId, Long postId, String chatLink, String message) {

        Member sender = memberRepository.findById(senderId).orElseThrow(MemberNotFoundException::new);

        Post receiverPost = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);


        MatchingMember matchingMember = MatchingMember.of(sender, receiverPost, chatLink, message);

        MatchingMember saved = matchingMemberRepository.save(matchingMember);

        return saved;
    }


    public List<MatchingMemberDto> getAllsentMail(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        List<MatchingMember> receiveMail = matchingMemberRepository.findAllByMemberIdAndIfNotChecked(member);
        return receiveMail.stream().map(MatchingMemberDto::of).toList();
    }

    public List<MatchingMemberDto> getAllReceiveMail(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        List<MatchingMember> sentMail = matchingMemberRepository.findAllByMemberIdAndIfNotMatched(member);
        return sentMail.stream().map(MatchingMemberDto::of).toList();
    }

    public Long getNumOfReceiveMail(Long receiverId) {
        Member receiver = memberRepository.findById(receiverId).orElseThrow(MemberNotFoundException::new);
        Long received = matchingMemberRepository.getNumOfReceiveMail(receiver);

        return received;
    }

    public Long getNumOfSentMail(Long senderId) {
        Member sender = memberRepository.findById(senderId).orElseThrow(MemberNotFoundException::new);
        Long sent = matchingMemberRepository.getNumOfSentMail(sender);

        return sent;
    }


}

