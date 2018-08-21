package com.test.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-jdbc-druid
 * @package: com.test.job
 * @email: cy880708@163.com
 * @date: 2018/8/21 下午3:39
 * @mofified By:
 */
@Component
@EnableScheduling
@Configurable
public class JobTask {

    private Logger logger = LoggerFactory.getLogger(JobTask.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Scheduled(fixedRate = 1000*1)
    public void updateJob(){
        int resFlag = jdbcTemplate.update("update invest set money=money+1 where id=10201808060000001");
        if(resFlag > 0) {
            logger.info("操作成功");
        } else {
            logger.info("操作失败");
        }

    }

}
