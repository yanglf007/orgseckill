package org.seckill.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class SeckillDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {

            long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.toString());
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 10);
        Assert.assertEquals(3,seckills.size());

    }
    @Test
    public void reduceNum() throws Exception {
        long id = 1000;
       int i= seckillDao.reduceNum(1001,new Date());
       Assert.assertEquals(1,i);

    }



}