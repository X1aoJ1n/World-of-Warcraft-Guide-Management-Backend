package com.goujiaoprohibited.management.pojo.Logs;


import com.goujiaoprohibited.management.IntArrayToStringConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="tb_bosslog")
@Entity
public class BossLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bossLogId;
    private String bossName;
    private int bossPoint;
    
    @Convert(converter = IntArrayToStringConverter.class)
    private int[] membersId;
    private int week;

    public int getBossLogId() {
        return bossLogId;
    }

    public void setBossLogId(int bossLogId) {
        this.bossLogId = bossLogId;
    }

    public String getBossName() {
        return bossName;
    }

    public int getBossPoint() {
        return bossPoint;
    }

    public int[] getMembersId() {
        return membersId;
    }

    public int getWeek() {
        return week;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public void setBossPoint(int bossPoint) {
        this.bossPoint = bossPoint;
    }

    public void setMembersId(int[] membersId) {
        this.membersId = membersId;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
