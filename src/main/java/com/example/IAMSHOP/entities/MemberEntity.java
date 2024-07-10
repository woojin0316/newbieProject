package com.example.IAMSHOP.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "memberId")
public class MemberEntity {
    private String memberId;
    private String memberPassword;
    private String memberAddr1;
    private String memberAddr2;
    private String memberAddr3;
    private String memberEmail;
    private int normalTel1;
    private int  normalTel2;
    private int normalTel3;
    private int tel1;
    private int tel2;
    private int tel3;
    private LocalDateTime createdAt;
    private boolean isAdmin;
    private boolean isDeleted;
    private boolean isSuspended;
}
