package com.goujiaoprohibited.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goujiaoprohibited.management.pojo.Logs.BossLog;

@Repository
public interface BossLogRepo extends CrudRepository<BossLog,Integer> {

}
