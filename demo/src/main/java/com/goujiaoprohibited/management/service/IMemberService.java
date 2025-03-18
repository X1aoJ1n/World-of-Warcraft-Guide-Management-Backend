package com.goujiaoprohibited.management.service;

import com.goujiaoprohibited.management.pojo.Members.Member;
import com.goujiaoprohibited.management.pojo.Members.MemberDTO;

public interface IMemberService {
    Member add(MemberDTO member);

    Member getMember(int memberId);

    Member edit(MemberDTO member);

    void deleteMember(int memberId);
}
