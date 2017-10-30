package org.seckill.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class SeckillServiceImplTest {
    @Autowired
    private SeckillService seckillService;
    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillService.queryAll(0, 4);
        Assert.assertEquals(3,seckills.size());
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill = seckillService.queryById(1001);
        Assert.assertNotNull(seckill);
    }

    @Test
    public void exporseSeckillURL() throws Exception {
        Exposer exposer = seckillService.exporseSeckillURL(1001);
        System.out.println(exposer.getMd5());
        Assert.assertNotNull(exposer.getMd5());

    }

    @Test
    public void executeSeckill() throws Exception {
        SeckillExecution seckillExecution = seckillService.executeSeckill(1001, 198234254322L, "68b0f36c7c43804a67b2ae11c9346ca8");
        System.out.println(seckillExecution.getState());
    }

}