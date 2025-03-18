package com.goujiaoprohibited.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goujiaoprohibited.management.MyBeanUtils;
import com.goujiaoprohibited.management.pojo.Members.Member;
import com.goujiaoprohibited.management.pojo.Members.MemberDTO;
import com.goujiaoprohibited.management.repository.MemberRepo;

@Service
public class MemberService implements IMemberService {

    @Autowired
    MemberRepo memberrepo;

    @Override
    public Member add(MemberDTO member){

        Member newMember = new Member();

        BeanUtils.copyProperties(member, newMember);

        newMember.setEP((short) 1000);
        newMember.setGP((short) 1000);

        return memberrepo.save(newMember);
    }

    @Override
    public Member getMember(int memberId) {
        return memberrepo.findById(memberId).orElseThrow(() -> {
            throw new IllegalArgumentException("补兑");
        });
    }

    @Override
    public Member edit(MemberDTO member) {
        Member existingMember = memberrepo.findById(member.getMemberId())
            .orElseThrow(() -> new RuntimeException("Member not found"));

        double ep = existingMember.getEP();
        double gp = existingMember.getGP();

        BeanUtils.copyProperties(member, existingMember, MyBeanUtils.getNullPropertyNames(member));

        if (existingMember.getEP() == 0) {
            existingMember.setEP(ep);
        }

        if (existingMember.getGP() == 0) {
            existingMember.setGP(gp);
        }

        return memberrepo.save(existingMember);
    }

    @Override
    public void deleteMember(int memberId) {
        memberrepo.deleteById(memberId);
    }

    
}
