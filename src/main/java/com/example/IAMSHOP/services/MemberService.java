package com.example.IAMSHOP.services;


import com.example.IAMSHOP.entities.MemberEntity;
import com.example.IAMSHOP.mappers.MemberMapper;
import com.example.IAMSHOP.regexes.MemberRegex;
import com.example.IAMSHOP.results.CommonResult;
import com.example.IAMSHOP.results.Result;
import com.example.IAMSHOP.results.user.LoginResult;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }



    public Result login(MemberEntity member) {
        if (member == null ||
            !MemberRegex.email.tests(member.getMemberEmail()) ||
            !MemberRegex.password.tests(member.getMemberPassword())) {
            System.out.println("정규화 안맞음");
            return CommonResult.FAILURE;
        }
        MemberEntity dbMember = this.memberMapper.selectMemberByMemberId(member.getMemberId());

        if (dbMember == null ||
            dbMember.isDeleted() ||
            !BCrypt.checkpw(member.getMemberPassword(), dbMember.getMemberPassword())) {
            //BCrypt 는 security pom.xml 다운 받아야됨.
            return CommonResult.FAILURE;
        }

        if (dbMember.isSuspended()) {
            return LoginResult.FAILURE_SUSPENDED;
        }

        member.setMemberId(dbMember.getMemberId());
        member.setMemberPassword(dbMember.getMemberPassword());
        member.setCreatedAt(dbMember.getCreatedAt());
        member.setAdmin(dbMember.isAdmin());
        member.setDeleted(dbMember.isDeleted());
        member.setSuspended(dbMember.isSuspended());
        return CommonResult.SUCCESS;
    }
}
