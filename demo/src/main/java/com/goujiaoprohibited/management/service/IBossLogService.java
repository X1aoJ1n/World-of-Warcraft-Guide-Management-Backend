package com.goujiaoprohibited.management.service;

import com.goujiaoprohibited.management.pojo.Logs.BossLog;

public interface IBossLogService {
    BossLog add(BossLog bossLog);

    BossLog get(int bossLogId);
    
    BossLog edit(BossLog bossLog);

    void delete(int bossLogId);
}