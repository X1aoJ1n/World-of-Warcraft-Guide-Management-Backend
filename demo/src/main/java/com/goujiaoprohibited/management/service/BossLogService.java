package com.goujiaoprohibited.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goujiaoprohibited.management.MyBeanUtils;
import com.goujiaoprohibited.management.pojo.Logs.BossLog;
import com.goujiaoprohibited.management.pojo.Members.Member;
import com.goujiaoprohibited.management.repository.BossLogRepo;
import com.goujiaoprohibited.management.repository.MemberRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BossLogService implements IBossLogService {

    @Autowired
    BossLogRepo bosslogrepo;

    @Autowired
    MemberRepo memberrepo;

    @Override
    public BossLog add(BossLog bossLog){

        BossLog newBossLog = new BossLog();

        BeanUtils.copyProperties(bossLog, newBossLog);

        for (int i = 0; i < bossLog.getMembersId().length; i++) {
            Member member = memberrepo.findById(bossLog.getMembersId()[i]).orElseThrow(() -> new RuntimeException("Member does not exists"));
            member.setEP(member.getEP() + bossLog.getBossPoint());
            memberrepo.save(member);
        }

        return bosslogrepo.save(newBossLog);
    }

    @Override
    public BossLog get(int bossLogId) {
        return bosslogrepo.findById(bossLogId).orElseThrow(() -> {
            throw new IllegalArgumentException("补兑");
        });
    }

    @Override
    public BossLog edit(BossLog bossLog) {
        BossLog oldBossLog = bosslogrepo.findById(bossLog.getBossLogId()).orElseThrow(() -> new RuntimeException("不存在"));

        for (int i = 0; i < oldBossLog.getMembersId().length; i++) {
            Member member = memberrepo.findById(oldBossLog.getMembersId()[i]).orElseThrow(() -> new RuntimeException("Member does not exists"));
            member.setEP(member.getEP() - oldBossLog.getBossPoint());
            memberrepo.save(member);
        }

        for (int i = 0; i < bossLog.getMembersId().length; i++) {
            Member member = memberrepo.findById(bossLog.getMembersId()[i]).orElseThrow(() -> new RuntimeException("Member does not exists"));
            member.setEP(member.getEP() + bossLog.getBossPoint());
            memberrepo.save(member);
        }

        BeanUtils.copyProperties(bossLog, oldBossLog, MyBeanUtils.getNullPropertyNames(bossLog));

        return bosslogrepo.save(oldBossLog);
    }

    @Override
    public void delete(int bossLogId) {
        BossLog oldBossLog = bosslogrepo.findById(bossLogId).orElseThrow(() -> new RuntimeException("不存在"));
        for (int i = 0; i < oldBossLog.getMembersId().length; i++) {
            Member member = memberrepo.findById(oldBossLog.getMembersId()[i]).orElseThrow(() -> new RuntimeException("Member does not exists"));
            member.setEP(member.getEP() - oldBossLog.getBossPoint());
            memberrepo.save(member);
        }
        bosslogrepo.deleteById(bossLogId);
    }
}
