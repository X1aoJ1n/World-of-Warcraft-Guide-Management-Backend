package com.goujiaoprohibited.management.service;

import com.goujiaoprohibited.management.pojo.Logs.LootLog;

public interface ILootLogService {
    LootLog add(LootLog lootLog);

    LootLog get(int lootLogId);
    
    LootLog edit(LootLog lootLog);

    void delete(int lootLogId);
}