package com.example.IAMSHOP.mappers;


import com.example.IAMSHOP.entities.EmailAuthEntity;
import com.example.IAMSHOP.entities.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    int insertEmailAuth(EmailAuthEntity emailAuth);

    int insertMember(MemberEntity member);

    MemberEntity selectMemberByMemberId(@Param("id") String memberId);

    int updateEmailAuth(EmailAuthEntity emailAuth);

    int updateMember (MemberEntity member);
}
