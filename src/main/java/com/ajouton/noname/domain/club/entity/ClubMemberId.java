package com.ajouton.noname.domain.club.entity;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ClubMemberId implements Serializable{

    private Long clubId;
    private Long userId;


}
