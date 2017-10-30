package org.seckill.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/15 0015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class RedisDaoTest {
   private RedisDao redisDao;
   @Autowired
   private SeckillDao seckillDao;
    @Before
    public void before(){
        redisDao = new RedisDao("192.168.0.69",6379);
      //redisDao = new RedisDao("192.168.0.69",6379,"mypass","mypass",60*60);
    }
    @Test
    public void getSeckill() throws Exception {
     Seckill seckill=   redisDao.getSeckill(1002L);
        System.out.println(seckill.toString());
    }

    @Test
    public void putSeckill() throws Exception {
        Seckill seckill= seckillDao.queryById(1002L);
        redisDao.putSeckill(seckill);
    }

}