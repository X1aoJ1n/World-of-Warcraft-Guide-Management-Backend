package com.goujiaoprohibited.management.service;

import com.goujiaoprohibited.management.pojo.Loots.Loot;

public interface ILootService {
    Loot add(Loot loot);

    Loot get(int lootId);

    Loot edit(Loot loot);

    void delete(int lootId);
}