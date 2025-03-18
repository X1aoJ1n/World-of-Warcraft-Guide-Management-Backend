package com.goujiaoprohibited.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goujiaoprohibited.management.pojo.Logs.LootLog;

@Repository
public interface LootLogRepo extends CrudRepository<LootLog,Integer> {

}
