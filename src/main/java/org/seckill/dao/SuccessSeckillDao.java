package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessSeckill;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public interface SuccessSeckillDao {
    int insertSuccessedKill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
    SuccessSeckill queryByIdWidthSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
