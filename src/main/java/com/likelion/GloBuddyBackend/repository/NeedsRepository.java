package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.Needs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeedsRepository extends JpaRepository<Needs, Long> {}
