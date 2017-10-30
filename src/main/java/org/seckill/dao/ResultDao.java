package org.seckill.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.seckill.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
@Component
public class ResultDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public Result queryTwo(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List <Result>list =sqlSession.selectList("org.seckill.dao.SuccessSeckillDao.queryTwo");
        return list.get(0);
    }
}
