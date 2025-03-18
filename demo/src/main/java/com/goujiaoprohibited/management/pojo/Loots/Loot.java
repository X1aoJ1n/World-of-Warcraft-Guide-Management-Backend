package com.goujiaoprohibited.management.pojo.Loots;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Table(name="tb_loot")
@Entity
public class Loot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int LootId;
    private int ilevel;
    private String type;
    private String lootName;
    private double point;

    public void setLootName(String lootName) {
        this.lootName = lootName;
    }

    public String getLootName() {
        return lootName;
    }

    public void setLootId(int lootId) {
        LootId = lootId;
    }

    public int getLootId() {
        return LootId;
    }

    public int getIlevel() {
        return ilevel;
    }
    public double getPoint() {
        return point;
    }
    public String getType() {
        return type;
    }

    public void setIlevel(int ilevel) {
        this.ilevel = ilevel;
    }

    @PrePersist
    @PreUpdate
    public void setPoint( ) {
        this.point = LootGPMapping.getPoint(this.type,this.ilevel);
    }

    public void setType(String type) {
        this.type = type;
    }
}
