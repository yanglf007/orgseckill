package org.seckill.dao;



import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public interface SeckillDao {
    /**
     * 减库存操作
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNum(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 查询秒杀详细信息
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 查询全部秒杀单
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
