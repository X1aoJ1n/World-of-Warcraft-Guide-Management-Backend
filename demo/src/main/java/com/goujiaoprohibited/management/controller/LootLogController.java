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
import com.goujiaoprohibited.management.pojo.Logs.LootLog;
import com.goujiaoprohibited.management.service.ILootLogService;

@RestController
@RequestMapping("/lootlog")

public class LootLogController {
    
    @Autowired
    ILootLogService lootLogServer;

    @PostMapping
    public ResponseMessage<LootLog> addLootLog(@Validated @RequestBody LootLog lootLog){
        LootLog newLootLog = lootLogServer.add(lootLog);
        return ResponseMessage.success(newLootLog);
    }

    @GetMapping("/{lootLogId}")
    public ResponseMessage<LootLog> getLootLog(@PathVariable int lootLogId){
        LootLog newLootLog = lootLogServer.get(lootLogId);
        return ResponseMessage.success(newLootLog);
    }

    @PutMapping
    public ResponseMessage<LootLog> editMember(@Validated @RequestBody LootLog lootLog){
        LootLog newLootLog = lootLogServer.edit(lootLog);
        return ResponseMessage.success(newLootLog);
    }

    @DeleteMapping("/{lootLogId}")
    public ResponseMessage<LootLog> deleteLootLog(@PathVariable int lootLogId){
        lootLogServer.delete(lootLogId);
        return ResponseMessage.success();
    }
}
