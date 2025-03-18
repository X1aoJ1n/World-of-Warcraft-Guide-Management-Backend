package com.goujiaoprohibited.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goujiaoprohibited.management.pojo.ResponseMessage;
import com.goujiaoprohibited.management.pojo.Members.Member;
import com.goujiaoprohibited.management.pojo.Members.MemberDTO;
import com.goujiaoprohibited.management.service.IMemberService;

@RestController
@RequestMapping("/user")

public class MemberController {
    
    @Autowired
    IMemberService memberService;

    @PostMapping
    public ResponseMessage<Member> addMember(@Validated @RequestBody MemberDTO member){
        Member newMember = memberService.add(member);
        return ResponseMessage.success(newMember);
    }

    @GetMapping("/{memberId}")
    public ResponseMessage<Member> getMember(@PathVariable int memberId){
        Member newMember = memberService.getMember(memberId);
        return ResponseMessage.success(newMember);
    }

    @PutMapping
    public ResponseMessage<Member> editMember(@Validated @RequestBody MemberDTO member){
        Member newMember = memberService.edit(member);
        return ResponseMessage.success(newMember);
    }
    
    @DeleteMapping("/{memberId}")
    public ResponseMessage<Member> deleteMember(@PathVariable int memberId){
        memberService.deleteMember(memberId);
        return ResponseMessage.success();
    }
}
