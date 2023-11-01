package com.ajouton.noname.domain.club.entity;

import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="club_members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@IdClass(ClubMemberId.class)
public class ClubMember extends BaseTimeEntity {

    @Id
    @Column(name = "club_id")
    private Long clubId;

    @Id
    @Column(name = "user_id")
    private Long userId;


    private String role;

    @Column(name = "is_view")
    private char isView;

    @Builder
    private ClubMember(String role,
                       char isView) {
        this.role = role;
        this.isView = isView;
    }

    public void setViewON(){
        this.isView = 'Y';
    }
    public void setViewOff(){
        this.isView = 'N';
    }

}
