package org.seckill.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessSeckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class SuccessSeckillDaoTest {
    @Autowired
    private SuccessSeckillDao successSeckillDao;
    @Test
    public void insertSuccessedKill() throws Exception {
       int result= successSeckillDao.insertSuccessedKill(1001,18080443484L);
        Assert.assertEquals(0,result);
    }

    @Test
    public void queryByIdWidthSeckill() throws Exception {
        SuccessSeckill successSeckill = successSeckillDao.queryByIdWidthSeckill(1001,1893434L);
        System.out.println(successSeckill.toString());
        Assert.assertNotNull(successSeckill);
    }

}