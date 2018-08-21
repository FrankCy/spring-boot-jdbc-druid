package com.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-jdbc-druid
 * @package: com.test.controller
 * @email: cy880708@163.com
 * @date: 2018/8/21 下午3:15
 * @mofified By:
 */
@RestController
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "id", required = true) String id) {
        String name = getNameById(id);
        return (name == null) ? "Hello World" : ("Hello " + name);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(@RequestParam(value = "id", required = true) String id) {
        String name = updateData(id);
        return (name == null) ? "Hello World" : ("Hello " + name);
    }

    public String getNameById(String id) {
        String sql = "select id from node where id = ? ";
        logger.info("SQL ： " + sql);
        List<String> list = jdbcTemplate.queryForList(sql, new Object[] {id}, String.class);
        logger.info("数据为 ： " + list.toString());
        return list.isEmpty() ? null : list.get(0);
    }

    public String updateData(String id) {
        String sql = "update invest set money  = money +1 where id = " + id;
        logger.info("SQL ： " + sql);
        int resInt = jdbcTemplate.update(sql);
        logger.info("修改状态 ： " + resInt);
        return "修改状态" + resInt;
    }

}
