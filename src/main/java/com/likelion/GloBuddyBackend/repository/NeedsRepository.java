package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.domain.Needs;
import com.likelion.GloBuddyBackend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NeedsRepository extends JpaRepository<Needs, Long> {
    Needs findByPost(Post post);
    @Query("select m from Needs m where m.post.postId =:postId")
    Needs findAllByPosts(Long postId);
}
