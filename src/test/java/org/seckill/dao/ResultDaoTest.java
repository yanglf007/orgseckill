package org.seckill.dao;

import org.junit.runner.RunWith;
import org.seckill.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ResultDaoTest {

    @Autowired
    private ResultDao resultDao;

    @org.junit.Test
    public void testQueryTwo(){
        Result result = resultDao.queryTwo();
        System.out.println(result.toString());
    }
}