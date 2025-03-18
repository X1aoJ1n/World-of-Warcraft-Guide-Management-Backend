package com.goujiaoprohibited.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goujiaoprohibited.management.pojo.Members.Member;

@Repository
public interface MemberRepo extends CrudRepository<Member, Integer> {

}
