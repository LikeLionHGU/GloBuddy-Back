package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.MatchingMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeedsRepository extends JpaRepository<MatchingMember, Long> {

}
