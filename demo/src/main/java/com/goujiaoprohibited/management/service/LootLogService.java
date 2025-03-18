package com.goujiaoprohibited.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goujiaoprohibited.management.pojo.Logs.LootLog;
import com.goujiaoprohibited.management.pojo.Loots.Loot;
import com.goujiaoprohibited.management.pojo.Members.Member;
import com.goujiaoprohibited.management.repository.LootLogRepo;
import com.goujiaoprohibited.management.repository.LootRepo;
import com.goujiaoprohibited.management.repository.MemberRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LootLogService implements ILootLogService {

    @Autowired
    LootLogRepo lootlogrepo;    
    
    @Autowired
    MemberRepo memberrepo;

    @Autowired
    LootRepo lootrepo;

    @Override
    public LootLog add(LootLog lootLog){

        Member member = memberrepo.findById(lootLog.getMemberId()).orElseThrow(() -> new RuntimeException("Member does not exists(loot log)"));
        Loot loot = lootrepo.findById(lootLog.getLootId()).orElseThrow(() -> new RuntimeException("loot does not exists"));

        member.setGP(member.getGP() + loot.getPoint());
        memberrepo.save(member);
        
        LootLog newLootLog = new LootLog();
        BeanUtils.copyProperties(lootLog, newLootLog);

        return lootlogrepo.save(newLootLog);
    }

    @Override
    public LootLog get(int lootLogId) {
        return lootlogrepo.findById(lootLogId).orElseThrow(() -> {
            throw new IllegalArgumentException("补兑");
        });
    }

    @Override
    public LootLog edit(LootLog lootLog) {
        LootLog editedLootLog = new LootLog();

        Member memberAdded = memberrepo.findById(lootLog.getMemberId()).orElseThrow(() -> new RuntimeException("memberAdded does not exists"));
        Loot lootAdded = lootrepo.findById(lootLog.getLootId()).orElseThrow(() -> new RuntimeException("lootAdded does not exists"));

        memberAdded.setGP(memberAdded.getGP() + lootAdded.getPoint());
        memberrepo.save(memberAdded);


        LootLog oldLootLog = lootlogrepo.findById(lootLog.getLootLogId()).orElseThrow(() -> new RuntimeException("oldLootLog does not exists"));

        Member memberDeleted = memberrepo.findById(oldLootLog.getMemberId()).orElseThrow(() -> new RuntimeException("memberDeleted does not exists"));
        Loot lootDeleted = lootrepo.findById(oldLootLog.getLootId()).orElseThrow(() -> new RuntimeException("lootDeleted does not exists"));

        memberDeleted.setGP(memberDeleted.getGP() - lootDeleted.getPoint());
        memberrepo.save(memberDeleted);


        BeanUtils.copyProperties(lootLog, editedLootLog);

        return lootlogrepo.save(editedLootLog);
    }

    @Override
    public void delete(int lootLogId) {

        LootLog oldLootLog = lootlogrepo.findById(lootLogId).orElseThrow(() -> new RuntimeException("oldLootLog does not exists"));

        Member member = memberrepo.findById(oldLootLog.getMemberId()).orElseThrow(() -> new RuntimeException("Member does not exists"));
        Loot loot = lootrepo.findById(oldLootLog.getLootId()).orElseThrow(() -> new RuntimeException("loot does not exists"));

        member.setGP(member.getGP() - loot.getPoint());
        memberrepo.save(member);

        lootlogrepo.deleteById(lootLogId);
    }
}
