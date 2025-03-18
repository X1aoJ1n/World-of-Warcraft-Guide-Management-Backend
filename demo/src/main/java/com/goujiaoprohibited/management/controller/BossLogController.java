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
import com.goujiaoprohibited.management.pojo.Logs.BossLog;
import com.goujiaoprohibited.management.service.IBossLogService;

@RestController
@RequestMapping("/bosslog")

public class BossLogController {
    
    @Autowired
    IBossLogService bossLogServer;

    @PostMapping
    public ResponseMessage<BossLog> addBossLog(@Validated @RequestBody BossLog bossLog){
        BossLog newBossLog = bossLogServer.add(bossLog);
        return ResponseMessage.success(newBossLog);
    }

    @GetMapping("/{bossLogId}")
    public ResponseMessage<BossLog> getBossog(@PathVariable int bossLogId){
        BossLog newBossLog = bossLogServer.get(bossLogId);
        return ResponseMessage.success(newBossLog);
    }

    @PutMapping
    public ResponseMessage<BossLog> editMember(@Validated @RequestBody BossLog bossLog){
        BossLog newBossLog = bossLogServer.edit(bossLog);
        return ResponseMessage.success(newBossLog);
    }

    @DeleteMapping("/{bossLogId}")
    public ResponseMessage<BossLog> deleteBossLog(@PathVariable int bossLogId){
        bossLogServer.delete(bossLogId);
        return ResponseMessage.success();
    }
}
