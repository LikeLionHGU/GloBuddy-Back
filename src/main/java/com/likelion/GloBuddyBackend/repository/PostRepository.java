package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
