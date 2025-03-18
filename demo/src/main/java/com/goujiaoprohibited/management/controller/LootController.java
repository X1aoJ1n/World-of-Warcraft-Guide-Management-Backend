package com.goujiaoprohibited.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goujiaoprohibited.management.pojo.ResponseMessage;
import com.goujiaoprohibited.management.pojo.Loots.Loot;
import com.goujiaoprohibited.management.service.ILootService;

@RestController
@RequestMapping("/loot")

public class LootController {
    
    @Autowired
    ILootService lootServer;

    @PostMapping
    public ResponseMessage<Loot> addLoot(@Validated @RequestBody Loot loot){
        Loot newLoot = lootServer.add(loot);
        return ResponseMessage.success(newLoot);
    }

    @GetMapping("/{lootId}")
    public ResponseMessage<Loot> getLoot(@PathVariable int lootId){
        Loot newLoot = lootServer.get(lootId);
        return ResponseMessage.success(newLoot);
    }

    @PutMapping
    public ResponseMessage<Loot> editLoot(@Validated @RequestBody Loot loot){
        Loot newLoot = lootServer.edit(loot);
        return ResponseMessage.success(newLoot);
    }
    @DeleteMapping("/{lootId}")
    public ResponseMessage<Loot> deleteLoot(@PathVariable int lootId){
        lootServer.delete(lootId);
        return ResponseMessage.success();
    }
}
