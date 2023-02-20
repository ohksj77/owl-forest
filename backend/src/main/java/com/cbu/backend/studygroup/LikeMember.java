package com.cbu.backend.studygroup;

import com.cbu.backend.config.audit.AuditListener;
import com.cbu.backend.config.audit.Auditable;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.domain.Member;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeMember implements Auditable {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public LikeMember(Member member, StudyGroup studyGroup) {
        this.member = member;
        this.studyGroup = studyGroup;
        addLike();
        this.baseTime = new BaseTime();
    }

    public void addLike() {
        studyGroup.getLikeMember().add(this);
    }

    public void cancelLike() {
        if (studyGroup.getLikeMember().isEmpty()) {
            throw new LikeCountMinusException();
        }
        studyGroup.getLikeMember().remove(this);
    }
}
