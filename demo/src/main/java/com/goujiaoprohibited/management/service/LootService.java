package com.goujiaoprohibited.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goujiaoprohibited.management.MyBeanUtils;
import com.goujiaoprohibited.management.pojo.Loots.Loot;
import com.goujiaoprohibited.management.repository.LootRepo;

@Service
public class LootService implements ILootService {

    @Autowired
    LootRepo lootrepo;

    @Override
    public Loot add(Loot loot){

        Loot newLoot = new Loot();

        BeanUtils.copyProperties(loot, newLoot);

        return lootrepo.save(newLoot);
    }

    @Override
    public Loot get(int lootId) {
        return lootrepo.findById(lootId).orElseThrow(() -> {
            throw new IllegalArgumentException("补兑");
        });
    }

    @Override
    public Loot edit(Loot loot) {
        Loot oldLoot = lootrepo.findById(loot.getLootId()).orElseThrow(() -> new RuntimeException("战利品不存在"));

        BeanUtils.copyProperties(loot, oldLoot, MyBeanUtils.getNullPropertyNames(loot));

        return lootrepo.save(oldLoot);
    }

    @Override
    public void delete(int lootId) {
        lootrepo.deleteById(lootId);
    }
}
