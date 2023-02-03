package com.cbu.backend.support.fixture.studygroup.entity;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studygroup.command.domain.StudyGroup;

import java.util.List;

public enum StudyGroupFixture {
    SAMPLE1(
            "k8s 스터디",
            "도커는 배우고 오세요",
            new AccountNo(),
            List.of(new AccountNo(), new AccountNo(), new AccountNo(), new AccountNo()));

    private String name;
    private String description;
    private AccountNo leaderId;
    private List<AccountNo> participantIds;

    StudyGroupFixture(
            String name, String description, AccountNo leaderId, List<AccountNo> participantIds) {
        this.name = name;
        this.description = description;
        this.leaderId = leaderId;
        this.participantIds = participantIds;
    }

    public StudyGroup toEntity() {
        return new StudyGroup(name, description, leaderId, participantIds);
    }

    public StudyGroup toEntity(AccountNo leaderId, List<AccountNo> participantIds) {
        return new StudyGroup(name, description, leaderId, participantIds);
    }
}
