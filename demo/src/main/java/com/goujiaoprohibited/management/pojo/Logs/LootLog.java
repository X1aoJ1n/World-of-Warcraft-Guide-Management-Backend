package com.goujiaoprohibited.management.pojo.Logs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="tb_lootlog")
@Entity
public class LootLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lootLogId;
    private int memberId;
    private int lootId;
    private int week;

    public int getLootId() {
        return lootId;
    }

    public void setLootId(int lootId) {
        this.lootId = lootId;
    }

    public int getLootLogId() {
        return lootLogId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getWeek() {
        return week;
    }

    public void setLoot(int lootId) {
        this.lootId = lootId;
    }

    public void setLootLogId(int lootLogId) {
        this.lootLogId = lootLogId;
    }
    
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    
    public void setWeek(int week) {
        this.week = week;
    }
}
