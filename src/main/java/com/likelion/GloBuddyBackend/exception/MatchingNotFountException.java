package com.likelion.GloBuddyBackend.exception;

public class MatchingNotFountException extends RuntimeException {
    public MatchingNotFountException() {
        super("해당 매칭 정보를 찾을 수 없습니다.");
    }

}