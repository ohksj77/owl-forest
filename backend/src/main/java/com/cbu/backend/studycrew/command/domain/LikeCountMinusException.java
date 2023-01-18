package com.cbu.backend.studycrew.command.domain;

public class LikeCountMinusException extends IllegalStateException {
    private static final String MESSAGE = "추천 수는 0 이하일 수 없습니다.";
    public LikeCountMinusException() {
        super(MESSAGE);
    }
}
